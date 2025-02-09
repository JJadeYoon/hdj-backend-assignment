package com.hdj.backend_assignment.global.enums

enum class SexCode(val code: String, val description: String) {
    MALE("M", "남"),
    FEMALE("F", "여");

    companion object {
        fun from(code: String): SexCode {
            return entries.first { it.code == code }
        }

        fun fromDescription(description: String): SexCode {
            return entries.first { it.description == description }
        }
    }
}