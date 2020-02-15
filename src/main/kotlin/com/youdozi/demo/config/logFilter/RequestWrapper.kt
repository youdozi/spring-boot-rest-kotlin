package com.youdozi.demo.config.logFilter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.util.StreamUtils
import java.io.ByteArrayInputStream
import java.io.IOException
import javax.servlet.ReadListener
import javax.servlet.ServletInputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

/**
 * HTTP Request to JSON 로직
 * @author youdozi
 */
class RequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {

    private val objectMapper: ObjectMapper = ObjectMapper()

    private lateinit var httpRequestBodyByteArray: ByteArray

    private var bis: ByteArrayInputStream? = null
    override fun getInputStream(): ServletInputStream {
        return object : ServletInputStream() {
            override fun isFinished(): Boolean {
                return bis!!.available() == 0
            }

            override fun isReady(): Boolean {
                return true
            }

            override fun setReadListener(readListener: ReadListener) {
                return
            }

            override fun read(): Int {
                return bis!!.read()
            }
        }
    }

    @Throws(IOException::class)
    fun convertToObject(): Any? {
        return if (httpRequestBodyByteArray.size == 0) null else objectMapper.readValue(httpRequestBodyByteArray, Any::class.java)
    }

    init {
        try {
            httpRequestBodyByteArray = StreamUtils.copyToByteArray(request.inputStream)
            bis = ByteArrayInputStream(httpRequestBodyByteArray)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}