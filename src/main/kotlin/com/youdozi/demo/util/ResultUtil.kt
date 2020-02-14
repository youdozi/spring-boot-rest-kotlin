package com.youdozi.demo.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

object ResultUtil {

    // Common Result
    fun setCommonResult(resultCode: String, resultMessage: String, status: HttpStatus): ResponseEntity<Map<String, Any>> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        return ResponseEntity(obj, status)
    }

    // Common Object Result
    fun setCommonResult(resultCode: String, resultMessage: String, temp: Any, status: HttpStatus): ResponseEntity<Map<String, Any>> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        val detailObj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        detailObj["content"] = temp
        obj["data"] = detailObj
        return ResponseEntity(obj, status)
    }

    // Common List Result
    fun setCommonResult(resultCode: String, resultMessage: String, temp: List<Any?>, status: HttpStatus): ResponseEntity<Map<String, Any>> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        val detailObj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        detailObj["content"] = temp
        obj["data"] = detailObj
        return ResponseEntity(obj, status)
    }

    // Common Result Error
    fun setCommonResult(resultCode: String, resultMessage: String, errorMessage: String, status: HttpStatus): ResponseEntity<Map<String, Any>> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        obj["errorMessage"] = errorMessage
        return ResponseEntity(obj, status)
    }
}