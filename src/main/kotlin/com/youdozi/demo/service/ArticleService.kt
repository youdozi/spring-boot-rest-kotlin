package com.youdozi.demo.service

interface ArticleService {

    fun findByName(name : String) : Map<String, Any>
}