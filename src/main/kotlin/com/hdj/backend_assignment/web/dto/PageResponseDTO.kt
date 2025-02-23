package com.hdj.backend_assignment.web.dto

import org.springframework.data.domain.Page

data class PageResponseDTO<T>(
    val content: List<T>,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val pageSize: Int
) {
    companion object {
        fun <T> from(page: Page<T>): PageResponseDTO<T> {
            return PageResponseDTO(
                content = page.content,
                totalElements = page.totalElements,
                totalPages = page.totalPages,
                currentPage = page.number + 1,
                pageSize = page.size
            )
        }
    }
}