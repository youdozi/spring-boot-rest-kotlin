package com.youdozi.demo.repository.specification

import com.youdozi.demo.entity.Article
import org.springframework.data.jpa.domain.Specification

object ArticleSpecification {

    fun useYnEqual(useYn: String?): Specification<Article>? = useYn?.let {
        Specification { root, query, cb ->
            cb.equal(root.get<String>("useYn"), useYn)
        }
    }
}