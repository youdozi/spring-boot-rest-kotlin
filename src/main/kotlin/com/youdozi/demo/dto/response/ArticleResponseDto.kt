package com.youdozi.demo.dto.response

import com.youdozi.demo.entity.Article
import java.time.LocalDateTime

/**
 * Response DTO
 */
class ArticleResponseDto{

    var seq: Long? = null

    var subject: String? = null

    var content: String? = null

    var name: String? = null

    var createdDate: LocalDateTime? = null

    var modifiedDate: LocalDateTime? = null

    constructor(param: Article){
        seq = param.seq
        subject = param.subject
        content = param.content
        name = param.name
        createdDate = param.createdDate
        modifiedDate = param.modifiedDate
    }
}