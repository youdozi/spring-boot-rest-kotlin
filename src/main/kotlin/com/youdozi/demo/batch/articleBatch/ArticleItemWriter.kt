package com.youdozi.demo.batch.articleBatch

import com.youdozi.demo.entity.TempArticle
import com.youdozi.demo.repository.TempArticleRepository
import org.springframework.batch.item.ItemWriter

class ArticleItemWriter(tempArticleRepository: TempArticleRepository) : ItemWriter<TempArticle?> {

    private var tempArticleRepository: TempArticleRepository = tempArticleRepository

    @Throws(Exception::class)
    override fun write(itemList: List<TempArticle?>) {
        tempArticleRepository.saveAll(itemList)
    }
}
