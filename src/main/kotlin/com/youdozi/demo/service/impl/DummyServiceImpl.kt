package com.youdozi.demo.service.impl

import com.youdozi.demo.service.DummyService
import com.youdozi.demo.util.ResultUtil
import org.springframework.stereotype.Service

@Service
class DummyServiceImpl : DummyService{

    override fun findByDummy(): Map<String, Any> =
            ResultUtil.setCommonResult("S", "http://112.216.84.67:9100/storage/spyder_v1.0.16_dev_store.apk")
}