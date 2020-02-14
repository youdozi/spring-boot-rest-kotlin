package com.youdozi.demo.dto

import javax.validation.constraints.*

class ArticleDto(

        @field:NotEmpty(message = "제목을 입력해주세요.")
        @field:NotBlank(message = "제목을 입력해주세요.")
        @field:Max(50, message = "제목은 50자 이내로 입력해야합니다.")
        var subject: String,

        @field:NotEmpty(message = "내용을 입력해주세요.")
        @field:NotBlank(message = "내용을 입력해주세요.")
        @field:Max(200, message = "내용은 200자 이내로 입력해야합니다.")
        var content: String,

        @field:NotEmpty(message = "사용자명을 입력해주세요.")
        @field:NotBlank(message = "사용자명을 입력해주세요.")
        var name: String,

        @field:NotEmpty(message = "패스워드를 입력해주세요.")
        @field:NotBlank(message = "패스워드를 입력해주세요.")
        @field:Min(4, message = "패스워드는 4자 이상입니다.")
        @field:Pattern(regexp = "/^[a-z0-9]{4,8}\$/;", message = "패스워드는 영어 & 숫자 조합입니다.")
        var password: String
)