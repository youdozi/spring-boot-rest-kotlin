package com.youdozi.demo.util

import java.util.*

object ResultUtil {

    // Common Result
    fun setCommonResult(resultCode: String, resultMessage: String): Map<String, Any> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        return obj
    }

    // Common Object Result
    fun setCommonResult(resultCode: String, resultMessage: String, tempObj: Any): Map<String, Any> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        val detailObj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        detailObj["content"] = tempObj
        obj["data"] = detailObj
        return obj
    }

    // Common List Result
    fun setCommonResult(resultCode: String, resultMessage: String, tempList: List<Any?>): Map<String, Any> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        val detailObj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        detailObj["content"] = tempList
        obj["data"] = detailObj
        return obj
    }

    // Common Result Error
    fun setCommonResult(resultCode: String, resultMessage: String, errorMessage: String): Map<String, Any> {
        val obj: MutableMap<String, Any> = LinkedHashMap()
        obj["resultCode"] = resultCode
        obj["resultMessage"] = resultMessage
        obj["errorMessage"] = errorMessage
        return obj
    }
}