package com.youdozi.demo.api

import com.youdozi.demo.dto.ArticleDto
import com.youdozi.demo.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/article")
class ArticleController {

	@Autowired
	private lateinit var articleService: ArticleService

	/**
	 * Get 방식
	 * return ResponseEntity Map 형태
	 */
	@GetMapping("/{name}")
	fun findByArticle(@PathVariable name: String): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.findByName(name), HttpStatus.OK)

	@PostMapping
	fun saveByArticle(@RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.saveByArticle(dto), HttpStatus.OK)

	@DeleteMapping("/{name}")
	fun deleteByArticle(@PathVariable name: String): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.deleteByArticle(name), HttpStatus.OK)
}