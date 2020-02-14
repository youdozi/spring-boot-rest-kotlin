package com.youdozi.demo.service.impl

import com.youdozi.demo.dto.ArticleDto
import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
import com.youdozi.demo.util.ResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated

@Validated
@Service
class ArticleServiceImpl : ArticleService{

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @Transactional(readOnly = true)
    override fun findByAll(pageable : Pageable): ResponseEntity<Map<String, Any>> =
        ResultUtil.setCommonResult("S", "성공하였습니다.", articleRepository.findAll(pageable), HttpStatus.OK)

    @Transactional(readOnly = true)
    override fun findByArticle(seq: Long): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq);

        return if (article != null) {
            ResultUtil.setCommonResult("S", "성공하였습니다.", article, HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

    @Transactional
    override fun save(dto: ArticleDto): ResponseEntity<Map<String, Any>> {

        articleRepository.save(Article(subject = dto.subject, content = dto.content, name = dto.name, password = dto.password));

        return ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
    }

    @Transactional
    override fun update(seq: Long, dto: ArticleDto): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq)

        // TODO 비밀번호 비교 로직 추가

        return if (article.isPresent){

            // DTO to Entity
            article.get().convert(dto);
            articleRepository.save(article.get())

            ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

    @Transactional
    override fun delete(seq: Long, dto: ArticleDto): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq)

        // TODO 비밀번호 비교 로직 추가

        return if (article.isPresent) {
            articleRepository.delete(article.get())
            ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

}