package com.richodemus.experiments.springboot

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ExampleRestController {
    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}
