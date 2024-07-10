package com.example.presignedurldemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PresignedUrlDemoApplication

fun main(args: Array<String>) {
    runApplication<PresignedUrlDemoApplication>(*args)
}
