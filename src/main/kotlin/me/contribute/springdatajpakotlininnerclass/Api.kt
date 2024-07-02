package me.contribute.springdatajpakotlininnerclass

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Api(
    private val dataInitializer: DataInitializer,
) {

    @GetMapping("/setup")
    fun asdf(): String {
        dataInitializer.init()
        return "good"
    }
}