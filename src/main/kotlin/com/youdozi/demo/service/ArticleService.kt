package com.youdozi.demo.service

import com.youdozi.demo.dto.ArticleDto

interface ArticleService {

    fun findByName(name: String): Map<String, Any>

    fun saveByArticle(dto: ArticleDto): Map<String, Any>

    fun deleteByArticle(name: String): Map<String, Any>
}