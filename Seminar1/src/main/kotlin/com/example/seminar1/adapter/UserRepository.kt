package com.example.seminar1.adapter

import com.example.seminar1.domain.model.UserDomainModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository: JpaRepository<UserDomainModel, Long> {

    @Query(value = "SELECT * FROM UserDomainModel WHERE name == UserDomainModel.name", nativeQuery = true)
    fun findUserByName(name: String): List<UserDomainModel>

    @Query(value = "SELECT * FROM UserDomainModel WHERE name == UserDomainModel.name AND part == UserDomainModel.part", nativeQuery = true)
    fun findUserByNameAndPart(name: String, part: String): List<UserDomainModel>
}