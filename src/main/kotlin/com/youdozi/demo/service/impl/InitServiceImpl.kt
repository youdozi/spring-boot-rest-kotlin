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
        articleRepository.save(Article(name = "test1"))
        articleRepository.save(Article(name = "test2"))
        articleRepository.save(Article(name = "test3"))
        articleRepository.save(Article(name = "test4"))
        articleRepository.save(Article(name = "test5"))
        articleRepository.save(Article(name = "test6"))
        articleRepository.save(Article(name = "test7"))
        articleRepository.save(Article(name = "test8"))
        articleRepository.save(Article(name = "test9"))
        articleRepository.save(Article(name = "test10"))
    }
}