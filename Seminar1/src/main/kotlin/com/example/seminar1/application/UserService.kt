package com.example.seminar1.application

import com.example.seminar1.adapter.UserRepository
import com.example.seminar1.application.dto.UserPostDto
import com.example.seminar1.application.dto.UserUpdateDto
import com.example.seminar1.domain.model.UserDomainModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun save(requestDto: UserPostDto): Long? = userRepository.save(requestDto.toEntity()).id

    @Transactional
    fun findAllUser(): MutableList<UserDomainModel> {
        val users = userRepository.findAll()

        if(users.size == 0) throw Exception("유저가 없습니다!")
        else return users
    }

    @Transactional
    fun findUserByName(name: String): List<UserDomainModel> = userRepository.findUserByName(name)

    @Transactional
    fun matchQuery(name: String, part: String): List<UserDomainModel> = userRepository.findUserByNameAndPart(name, part)

    @Transactional
    fun update(id: Long, requestDto: UserUpdateDto): Long {
        val user = userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("해당하는 유저가 없습니다.")

        user.name = requestDto.name
        user.part = requestDto.part

        return id
    }

    @Transactional
    fun delete(id: Long) = userRepository.deleteById(id)
}