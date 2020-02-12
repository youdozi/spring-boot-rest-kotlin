package com.youdozi.demo.api

import com.youdozi.demo.service.DummyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/dummy")
class DummyController {

    @Autowired
    private lateinit var dummyService : DummyService

    @GetMapping
    fun findByDummy(): ResponseEntity<Map<String, Any>> =
            ResponseEntity(dummyService.findByDummy(), HttpStatus.OK)
}