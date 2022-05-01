package com.example.seminar1.application.controller

import com.example.seminar1.application.UserService
import com.example.seminar1.application.dto.UserPostDto
import com.example.seminar1.application.dto.UserUpdateDto
import com.example.seminar1.domain.model.UserDomainModel
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("")
    fun findAllUser(): MutableList<UserDomainModel> = userService.findAllUser()

    @GetMapping("/name/{name}")
    fun findUserByName(@PathVariable name: String): List<UserDomainModel> = userService.findUserByName(name)

    @GetMapping("/info/")
    fun matchQuery(@RequestParam part: String, @RequestParam name: String): List<UserDomainModel> = userService.matchQuery(name, part)

    @PostMapping()
    fun save(@RequestBody requestDto: UserPostDto) = userService.save(requestDto)

    @PutMapping()
    fun update(@PathVariable id: Long, @RequestBody requestDto: UserUpdateDto) = userService.update(id, requestDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = userService.delete(id)
}