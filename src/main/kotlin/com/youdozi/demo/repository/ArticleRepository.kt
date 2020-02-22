package com.youdozi.demo.repository

import com.youdozi.demo.entity.Article
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ArticleRepository : JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

}