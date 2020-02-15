package com.youdozi.demo.service.impl

import com.youdozi.demo.dto.request.ArticleRequestDto
import com.youdozi.demo.dto.response.ArticleResponseDto
import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
import com.youdozi.demo.util.ResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated

@Validated
@Service
class ArticleServiceImpl : ArticleService{

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Transactional(readOnly = true)
    override fun findByAll(pageable : Pageable): ResponseEntity<Map<String, Any>> =
        ResultUtil.setCommonResult("S", "성공하였습니다.",
                                    articleRepository.findByUseYn("Y", pageable)
                                                     .stream()
                                                     .map {obj -> ArticleResponseDto(obj)}, HttpStatus.OK)

    @Transactional(readOnly = true)
    override fun findByArticle(seq: Long): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq);

        return if (article.isPresent && article.get().useYn.equals("Y")) {
            ResultUtil.setCommonResult("S", "성공하였습니다.", article, HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

    @Transactional
    override fun save(requestDto: ArticleRequestDto): ResponseEntity<Map<String, Any>> {

        articleRepository.save(Article(subject = requestDto.subject, content = requestDto.content, name = requestDto.name, password = passwordEncoder.encode(requestDto.password), useYn = "Y"));

        return ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
    }

    @Transactional
    override fun update(seq: Long, requestDto: ArticleRequestDto): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq)

        return if (article.isPresent && article.get().useYn.equals("Y")) {

            // 비밀번호 체크
            if(!passwordEncoder.matches(requestDto.password, article.get().password))
                return ResultUtil.setCommonResult("E", "패스워드가 맞지 않습니다.", HttpStatus.UNAUTHORIZED)

            // DTO to Entity
            article.get().convert(requestDto);
            articleRepository.save(article.get())

            ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

    @Transactional
    override fun delete(seq: Long, requestDto: ArticleRequestDto): ResponseEntity<Map<String, Any>> {

        // 조회
        val article = articleRepository.findById(seq)

        return if (article.isPresent && article.get().useYn.equals("Y")) {

            // 비밀번호 체크
            if(!passwordEncoder.matches(requestDto.password, article.get().password))
                return ResultUtil.setCommonResult("E", "패스워드가 맞지 않습니다.", HttpStatus.UNAUTHORIZED)

            article.get().useYn = "N"
            articleRepository.save(article.get())
            ResultUtil.setCommonResult("S", "성공하였습니다.", HttpStatus.OK)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.", HttpStatus.OK)
        }
    }

}