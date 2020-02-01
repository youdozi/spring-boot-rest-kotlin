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

	@GetMapping
	fun findByAll(): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.findByAll(), HttpStatus.OK)

	@GetMapping("/{name}")
	fun findByArticle(@PathVariable name: String): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.findByName(name), HttpStatus.OK)

	@PostMapping
	fun save(@RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.save(dto), HttpStatus.OK)

	@DeleteMapping("/{name}")
	fun deleteByName(@PathVariable name: String): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.deleteByName(name), HttpStatus.OK)

	@PutMapping("/{name}")
	fun updateByName(@PathVariable name: String, @RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
			ResponseEntity(articleService.updateByName(name, dto), HttpStatus.OK)
}