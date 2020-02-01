package com.youdozi.demo.service.impl

import com.youdozi.demo.dto.ArticleDto
import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
import com.youdozi.demo.util.ResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ArticleServiceImpl : ArticleService{

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @Transactional(readOnly = true)
    override fun findByAll(): Map<String, Any> =
        ResultUtil.setCommonResult("S", "성공하였습니다.", articleRepository.findAll())

    @Transactional(readOnly = true)
    override fun findByName(name: String): Map<String, Any> {

        // 조회
        val article = articleRepository.findByName(name)

        return if (article != null) {
            ResultUtil.setCommonResult("S", "성공하였습니다.", article)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.")
        }
    }

    @Transactional
    override fun save(dto: ArticleDto): Map<String, Any> {

        // 중복 체크
        val article = dto.name?.let { articleRepository.findByName(it) }

        return if (article == null){
            articleRepository.save(Article(name = dto.name))
            ResultUtil.setCommonResult("S", "성공하였습니다.")
        } else {
            ResultUtil.setCommonResult("E", "중복된 데이터가 있습니다.")
        }
    }

    @Transactional
    override fun deleteByName(name: String): Map<String, Any> {

        // 조회
        val article = articleRepository.findByName(name)

        return if (article != null) {
            articleRepository.delete(article)
            ResultUtil.setCommonResult("S", "성공하였습니다.")
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.")
        }
    }

    @Transactional
    override fun updateByName(name: String, dto: ArticleDto): Map<String, Any> {

        // 조회
        val article = articleRepository.findByName(name)

        return if (article != null){

            // DTO to Entity
            article.convert(dto)
            articleRepository.save(article)
            ResultUtil.setCommonResult("S", "성공하였습니다.")
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.")
        }
    }
}