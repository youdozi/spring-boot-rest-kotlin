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

    // Common Result
    fun setCommonResult(resultCode: String, resultMessage: String, temp: Any, status: HttpStatus): ResponseEntity<Map<String, Any>> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        obj["data"] = temp
        return ResponseEntity(obj, status)
    }
}