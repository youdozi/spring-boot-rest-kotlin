package com.youdozi.demo.api

import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController {

	@Autowired
	private lateinit var articleService: ArticleService

	/**
	 * Get 방식
	 * return ResponseEntity Map 형태
	 */
	@GetMapping
	fun article(@RequestParam(value="name", defaultValue="") name: String): ResponseEntity<Map<String, Any>>{

		/*
		var obj = mutableMapOf<String, Any>()

		obj.put("name", name)
		obj.put("resultCode", "S")
		obj.put("resultMessage", "성공하였습니다.")

		 */

		return ResponseEntity(articleService.findByName(name), HttpStatus.OK)
	}
}