package com.youdozi.demo.service

import com.youdozi.demo.dto.ArticleDto

interface ArticleService {

    fun findByAll(): Map<String, Any>

    fun findByName(name: String): Map<String, Any>

    fun save(dto: ArticleDto): Map<String, Any>

    fun deleteByName(name: String): Map<String, Any>

    fun updateByName(name: String, dto: ArticleDto): Map<String, Any>
}