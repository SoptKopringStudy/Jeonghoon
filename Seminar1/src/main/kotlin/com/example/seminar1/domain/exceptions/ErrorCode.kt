package com.example.seminar1.domain.exceptions

import lombok.Getter

@Getter
enum class ErrorCode(private val code: Int) {
    NO_EXIST_USER(4000),
    NO_USER_NAME(4001),
    INVALID_QUERY(4002)
}