package com.youdozi.demo.service.impl

import com.youdozi.demo.entity.Article
import com.youdozi.demo.repository.ArticleRepository
import com.youdozi.demo.service.InitService
import com.youdozi.demo.util.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@Service
class InitServiceImpl : InitService {

    @Autowired
    private lateinit var articleRepository : ArticleRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    /**
     * article 데이터 임의 생성
     */
    @PostConstruct
    @Transactional
    override fun init() {

        val articleList = ArrayList<Article>()

        var password = passwordEncoder.encode(PasswordUtil.passwordGenerate())

        for(i in 1..50)
            articleList.add(Article(subject = "subject$i", content = "content$i", name = "test$i", password = password, useYn = "Y"))

        articleRepository.saveAll(articleList)
    }
}