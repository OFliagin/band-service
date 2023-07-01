package com.fas.miusic.band.bandservice.adapter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/band")
class BandController {

    @GetMapping("/test")
    fun getHello() : String{
        return "HelloController"
    }
}