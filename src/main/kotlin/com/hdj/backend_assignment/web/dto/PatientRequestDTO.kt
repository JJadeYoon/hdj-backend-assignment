package com.hdj.backend_assignment.web.dto

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class PatientRequestDTO {

    data class RegisterDTO(
        val hospitalId: Long,
        val patientName: String,
        val registrationNumber: String,
        val sexCode: String,
        val birthDate: String? = null,
        val phoneNumber: String? = null
    )

    class UpdateDTO {
        var patientName: String? = null
        var registrationNumber: String? = null
        var sexCode: String? = null
        var birthDate: String? = null
        var phoneNumber: String? = null
    }

    data class SearchDTO(
        val pageNo: Int = 1,
        val pageSize: Int = 10,
        val patientName: String? = null,
        val registrationNumber: String? = null,
        val birthDate: String? = null,
    ) {
        fun toPageable(): Pageable {
            return PageRequest.of(pageNo - 1, pageSize)
        }
    }
}