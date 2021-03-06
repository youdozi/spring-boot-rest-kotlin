package com.youdozi.demo.util

import java.util.*

object PasswordUtil {

    /**
     * 패스워드 생성기
     */
    fun passwordGenerate() : String {
        val rnd = Random()
        val buf = StringBuffer()
        for (i in 0..3) {
            if (rnd.nextBoolean()) {
                buf.append((rnd.nextInt(26) + 97).toChar())
            } else {
                buf.append(rnd.nextInt(10))
            }
        }
        return buf.toString()
    }
}