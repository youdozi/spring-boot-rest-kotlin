package com.youdozi.demo.config.logFilter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.io.IOException
import javax.servlet.http.HttpServletResponse

/**
 * HTTP Response to JSON 로직
 * @author youdozi
 */
class ResponseWrapper(response: HttpServletResponse?) : ContentCachingResponseWrapper(response!!) {
    private val objectMapper: ObjectMapper = ObjectMapper()
    @Throws(IOException::class)
    fun convertToObject(): Any {
        return objectMapper.readValue(contentAsByteArray, Any::class.java)
    }

}