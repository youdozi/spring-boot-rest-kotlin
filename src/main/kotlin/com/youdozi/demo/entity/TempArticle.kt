package com.youdozi.demo.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
class TempArticle(
    // 일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var seq: Long? = null,

    // 이름
    @Column(nullable = false, length = 50)
    var name: String? = null,

    // 상세
    @Column(nullable = false, length = 200)
    var content: String? = null,

    // 제목
    @Column(nullable = false, length = 20)
    var subject: String? = null

) : BaseEntity()
