package com.youdozi.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder

@EnableJpaAuditing
@SpringBootApplication
class SpringBootRestKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringBootRestKotlinApplication>(*args)
}