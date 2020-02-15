package com.youdozi.demo.dto.request

import javax.validation.constraints.*

/**
 * Request DTO
 */
class ArticleRequestDto(

        @field:NotEmpty(message = "제목을 입력해주세요.")
        @field:NotBlank(message = "제목을 입력해주세요.")
        @field:Size(min = 1, max = 50, message = "제목은 50자 이내로 입력해야합니다.")
        var subject: String,

        @field:NotEmpty(message = "내용을 입력해주세요.")
        @field:NotBlank(message = "내용을 입력해주세요.")
        @field:Size(min = 1, max = 200, message = "내용은 200자 이내로 입력해야합니다.")
        var content: String,

        @field:NotEmpty(message = "사용자명을 입력해주세요.")
        @field:NotBlank(message = "사용자명을 입력해주세요.")
        var name: String,

        @field:NotEmpty(message = "패스워드를 입력해주세요.")
        @field:NotBlank(message = "패스워드를 입력해주세요.")
        @field:Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{4,20}$", message = "패스워드는 영어 & 숫자 조합입니다.")
        @field:Size(min = 4, max = 20, message = "패스워드는 4자 이상입니다.")
        var password: String
)