package com.example.seminar1.application.dto

import com.example.seminar1.domain.model.UserDomainModel

data class UserPostDto(
    val name: String,
    val part: String
) {
    fun toEntity(): UserDomainModel = UserDomainModel(
        name = name,
        part = part
    )
}
