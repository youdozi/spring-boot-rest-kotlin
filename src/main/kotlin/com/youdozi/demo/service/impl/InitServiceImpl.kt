package com.youdozi.demo.service.impl

import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.InitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@Service
class InitServiceImpl : InitService {

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @PostConstruct
    @Transactional
    override fun init() {
        articleRepository.save(Article(1, "test1"))
        articleRepository.save(Article(2, "test2"))
        articleRepository.save(Article(3, "test3"))
        articleRepository.save(Article(4, "test4"))
        articleRepository.save(Article(5, "test5"))
    }
}