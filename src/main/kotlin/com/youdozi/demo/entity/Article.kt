package com.youdozi.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        val name: String? = null
)