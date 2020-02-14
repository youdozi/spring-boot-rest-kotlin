package com.youdozi.demo.service.impl

import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.InitService
import com.youdozi.demo.util.PasswordUtil
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

        val articleList = ArrayList<Article>()

        for(i in 1..500)
            articleList.add(Article(subject = "subject$i", content = "content$i", name = "test$i", password = PasswordUtil.passwordGenerate()))

        articleRepository.saveAll(articleList)
    }
}