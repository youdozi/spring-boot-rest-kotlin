package com.youdozi.demo.repository

import com.youdozi.demo.entity.TempArticle
import org.springframework.data.jpa.repository.JpaRepository

interface TempArticleRepository : JpaRepository<TempArticle, Long> {
}
