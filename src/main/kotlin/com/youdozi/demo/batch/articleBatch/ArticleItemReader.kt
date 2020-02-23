package com.youdozi.demo.batch.articleBatch

import com.youdozi.demo.entity.Article
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.persistence.EntityManagerFactory

@Configuration
class ArticleItemReader {
    @Bean(destroyMethod = "")
    @Throws(Exception::class)
    fun articleReader(entityManagerFactory: EntityManagerFactory): JpaPagingItemReader<Article?> {
        val jpqlQuery = "SELECT a FROM Article a " +
                            "WHERE a.batchYn = :batchYn " +
                            "ORDER BY a.seq ASC"
        // JpaPaging 버그 수정
        val reader: JpaPagingItemReader<Article?> = object : JpaPagingItemReader<Article?>() {
            override fun getPage(): Int {
                return 0
            }
        }
        reader.setQueryString(jpqlQuery)
        reader.setEntityManagerFactory(entityManagerFactory)
        reader.pageSize = 100
        reader.afterPropertiesSet()
        reader.isSaveState = true
        reader.setName("articleItemReader")
        val parameter: MutableMap<String, Any> = HashMap()
        parameter["batchYn"] = "N"
        reader.setParameterValues(parameter)
        return reader
    }
}
