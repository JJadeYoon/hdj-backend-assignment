package com.hdj.backend_assignment.apiPayload

import com.hdj.backend_assignment.apiPayload.code.SuccessStatus

data class ApiResponse<T>(
    val isSuccess: Boolean = false,
    val code: String? = null,
    val message: String? = null,
    val result: T? = null
) {
    companion object {
        fun <T> ok(result: T): ApiResponse<T> {
            return ApiResponse(isSuccess = true, SuccessStatus._OK.code, SuccessStatus._OK.message, result = result)
        }

        fun fail(code: String, message: String): ApiResponse<Nothing> {
            return ApiResponse(isSuccess = false, code = code, message = message)
        }
    }
}