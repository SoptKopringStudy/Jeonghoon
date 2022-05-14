package com.example.seminar1.domain.model

import javax.persistence.*

@Entity
class UserDomainModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 50, nullable = false)
    var name: String,

    @Column(length = 20, nullable = false)
    var part: String
)