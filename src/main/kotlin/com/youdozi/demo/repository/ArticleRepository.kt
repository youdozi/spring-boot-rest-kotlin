package com.youdozi.demo.repository

import com.youdozi.demo.entity.Article
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {

    fun findByUseYn(useYn : String, pageable: Pageable) : List<Article>
}