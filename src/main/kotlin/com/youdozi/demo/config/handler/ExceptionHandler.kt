package com.youdozi.demo.config.handler

import com.youdozi.demo.util.ResultUtil
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Valid 메시지 통합
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun methodArgumentNotValidExceptionHandler(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {

        val errors = HashMap<String, String>()

        for (violation in ex.bindingResult.allErrors) {
            if (violation is FieldError) {
                errors[violation.field] = violation.defaultMessage.toString()
            }
        }

        return ResultUtil.setCommonResult("E", "검증에 실패하였습니다.", errors, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(BindException::class)
    @ResponseBody
    fun bindException(ex: BindException): ResponseEntity<Map<String, Any>> {

        val errors = HashMap<String, String>()

        for (violation in ex.bindingResult.allErrors) {
            if (violation is FieldError) {
                errors[violation.field] = violation.defaultMessage.toString()
            }
        }

        return ResultUtil.setCommonResult("E", "검증에 실패하였습니다.", errors, HttpStatus.BAD_REQUEST)
    }
}