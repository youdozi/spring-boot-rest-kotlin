package com.youdozi.demo.service.impl

import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.ArticleService
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

        val obj = mutableMapOf<String, Any>()

        if(article.id != null){
            obj.put("data", article)
            obj.put("resultCode", "S")
            obj.put("resultMessage", "성공하였습니다.")
        } else {
            obj.put("resultCode", "E")
            obj.put("resultMessage", "데이터가 없습니다.")
        }

        return obj
    }
}