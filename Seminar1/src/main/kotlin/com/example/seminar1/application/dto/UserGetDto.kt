package com.example.seminar1.application.dto

import com.example.seminar1.domain.model.UserDomainModel

data class UserGetDto(
    val id: Long,
    val name: String,
    val part: String
) {
    constructor(userDomainModel: UserDomainModel) : this(
        id = userDomainModel.id!!,
        name = userDomainModel.name,
        part = userDomainModel.part
    )
}