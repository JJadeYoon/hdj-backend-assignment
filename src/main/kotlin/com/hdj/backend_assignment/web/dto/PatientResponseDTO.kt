package com.hdj.backend_assignment.web.dto

class PatientResponseDTO {

    data class RegisterResultDTO(
        val patientId: Long?,
        val hospitalId: Long?,
        val patientName: String,
        val registrationNumber: String
    )

    data class GetResultDTO(
        val patientId: Long?,
        val hospitalId: Long?,
        val patientName: String,
        val registrationNumber: String,
        val sexCode: String,
        val birthDate: String?,
        val phoneNumber: String?
    )

    class PageResponse<T> {

    }
}
