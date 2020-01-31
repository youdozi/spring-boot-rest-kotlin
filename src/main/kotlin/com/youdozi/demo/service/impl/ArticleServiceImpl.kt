package com.youdozi.demo.service.impl

import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
import com.youdozi.demo.util.ResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ArticleServiceImpl : ArticleService{

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @Transactional
    override fun findByName(name: String): Map<String, Any> {
        val article = articleRepository.findByName(name)

        return if (article != null) {
            ResultUtil.setCommonResult("S", "성공하였습니다.", article)
        } else {
            ResultUtil.setCommonResult("E", "데이터가 없습니다.")
        }
    }
}