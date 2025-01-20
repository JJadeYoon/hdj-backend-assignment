package com.hdj.backend_assignment.apiPayload.code

enum class SuccessStatus (
    val code: String,
    val message: String
) {
    _OK(
        "200",
        "OK"
    );  // 세미콜론은 enum 상수와 메서드/프로퍼티를 구분할 때 필요

    fun isSuccess(): Boolean {
        return this == _OK
    }
}
