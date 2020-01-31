package com.youdozi.demo.repository

import com.youdozi.demo.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Int> {

    fun findByName(name : String) : Article?
}