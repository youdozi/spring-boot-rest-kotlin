package com.youdozi.demo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.youdozi.demo.dto.request.ArticleRequestDto
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

/**
 * Article Entity
 */
@Entity
@DynamicUpdate
class Article(

        // 일련번호
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var seq: Long? = null,

        // 이름
        @Column(nullable = false, length = 50)
        var name: String? = null,

        // 상세
        @Column(nullable = false, length = 200)
        var content: String? = null,

        // 제목
        @Column(nullable = false, length = 20)
        var subject: String? = null,

        // 패스워드
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Column(nullable = false, length = 200)
        var password: String? = null,

        // 사용여부(Y, N)
        @Column(nullable = false, length = 1)
        var useYn: String? = null

) : BaseEntity() {

    fun convert(obj: ArticleRequestDto) {
        content = obj.content
        subject = obj.subject
    }
}
