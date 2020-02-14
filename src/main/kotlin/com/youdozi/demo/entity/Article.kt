package com.youdozi.demo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.youdozi.demo.dto.ArticleDto
import javax.persistence.*

@Entity
class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var seq: Long? = null,

        @Column(nullable = false, length = 50)
        var name: String? = null,

        @Column(nullable = false, length = 200)
        var content: String? = null,

        @Column(nullable = false, length = 20)
        var subject: String? = null,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Column(nullable = false, length = 200)
        var password: String? = null

) : BaseEntity() {

    fun convert(obj: ArticleDto) {
        content = obj.content
        subject = obj.subject
    }
}
