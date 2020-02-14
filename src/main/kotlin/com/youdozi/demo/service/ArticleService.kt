package com.youdozi.demo.service

import com.youdozi.demo.dto.ArticleDto
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface ArticleService {

    fun findByAll(pageable : Pageable): ResponseEntity<Map<String, Any>>

    fun findByArticle(seq: Long): ResponseEntity<Map<String, Any>>

    fun save(dto: ArticleDto): ResponseEntity<Map<String, Any>>

    fun update(seq: Long, dto: ArticleDto): ResponseEntity<Map<String, Any>>

    fun delete(seq: Long, dto: ArticleDto): ResponseEntity<Map<String, Any>>
}