package com.youdozi.demo.batch.articleBatch

import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import org.springframework.batch.core.ItemReadListener
import org.springframework.stereotype.Component

@Component
class ArticleItemReaderListener(articleRepository: ArticleRepository) : ItemReadListener<Article> {

    private var articleRepository : ArticleRepository = articleRepository

    override fun onReadError(ex: Exception) {
    }

    override fun beforeRead() {
    }

    override fun afterRead(item: Article) {
        item.batchYn = "Y"
        articleRepository.save(item)
    }
}
