package com.youdozi.demo.entity

import com.youdozi.demo.dto.ArticleDto
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int? = null,
        var name: String? = null

){

    fun convert(obj: ArticleDto) {
        name = obj.name
    }
}
