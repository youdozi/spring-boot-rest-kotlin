package com.youdozi.demo.config.logFilter

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.time.Duration
import java.time.LocalDateTime
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * RequestLog에 API 요청 및 응답 데이터를 저장 및 필터링 하기 위한 파일
 * RequestLog에 어마어마한 데이터가 쌓이기에 안정화되면 응답코드 200을 제외한 나머지만 넣는 작업이 필요
 * @author youdozi
 */
@Configuration
@Component
class LogFilter : OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(LogFilter::class.java)

    override fun destroy() {}
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, filterChain: FilterChain) {

        log.info("==============================================================================================")
        log.info("요청 시작!!!!!")
        log.info("==============================================================================================")

        val startDate : LocalDateTime = LocalDateTime.now()

        val endDate : LocalDateTime = LocalDateTime.now()
        var calc = Duration.between(startDate, endDate).nano

        log.info("==============================================================================================")
        log.info("요청 종료!!!!! 시작: $startDate 종료: $endDate 응답시간: $calc")
        log.info("==============================================================================================")

        filterChain.doFilter(req, res)
    }
}