package com.youdozi.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SpringBootRestKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringBootRestKotlinApplication>(*args)
}
