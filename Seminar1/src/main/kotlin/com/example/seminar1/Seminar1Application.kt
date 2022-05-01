package com.example.seminar1

import com.example.seminar1.application.controller.UserController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Seminar1Application

fun main(args: Array<String>) {
	runApplication<UserController>(*args)
}
