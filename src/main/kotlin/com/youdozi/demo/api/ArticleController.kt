package com.youdozi.demo.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController {
	
	@GetMapping
	fun article(@RequestParam(value="name", defaultValue="") name: String): ResponseEntity<Map<String, Any>>{

		val obj = mutableMapOf<String, Any>()

		obj.put("name", name)
		obj.put("resultCode", "S")
		obj.put("resultMessage", "성공하였습니다.")

		return ResponseEntity(obj, HttpStatus.OK)
	}
}