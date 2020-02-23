package com.youdozi.demo.batch.articleBatch

import com.youdozi.demo.entity.Article
import com.youdozi.demo.entity.TempArticle
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class ArticleItemProcessor : ItemProcessor<Article, TempArticle> {

    @Throws(Exception::class)
    override fun process(item: Article): TempArticle {
        return TempArticle(seq = item.seq, subject = item.subject, content = item.content, name = item.name)
    }
}
