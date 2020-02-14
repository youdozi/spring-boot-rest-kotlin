package com.youdozi.demo.api

import com.youdozi.demo.dto.ArticleDto
import com.youdozi.demo.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/article")
class ArticleController {

    @Autowired
    private lateinit var articleService: ArticleService

    /**
     * 목록 조회
     */
    @GetMapping
    fun findByAll(@PageableDefault(sort = ["createdDate"], direction = Sort.Direction.DESC, size = 10) pageable: Pageable): ResponseEntity<Map<String, Any>> =
            articleService.findByAll(pageable)

    /**
     * 상세 조회
     */
    @GetMapping("/{seq}")
    fun findByArticle(@PathVariable seq: Long): ResponseEntity<Map<String, Any>> =
            articleService.findByArticle(seq)

    /**
     * 게시글 등록
     */
    @PostMapping
    fun save(@Valid @RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
            articleService.save(dto)

    /**
     * 게시글 수정
     */
    @PutMapping("/{seq}")
    fun update(@PathVariable seq: Long, @Valid @RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
            articleService.update(seq, dto)

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{seq}")
    fun delete(@PathVariable seq: Long, @Valid @RequestBody dto: ArticleDto): ResponseEntity<Map<String, Any>> =
            articleService.delete(seq, dto)
}