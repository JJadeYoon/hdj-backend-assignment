package com.hdj.backend_assignment.global.enums

enum class VisitStatusCode(val code: String, val description: String) {
    VISIT("1", "방문중"),
    ABSENCE("2", "종료"),
    LATE("3", "취소"),
}