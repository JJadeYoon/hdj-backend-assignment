package com.hdj.backend_assignment.web.dto

class PatientResponseDTO {

    data class RegisterResultDTO(
        val patientId: Long?,
        val hospitalId: Long?,
        val patientName: String,
        val registrationNumber: String
    )

    data class PatientDTO(
        val patientId: Long?,
        val hospitalId: Long?,
        val patientName: String,
        val registrationNumber: String,
        val sexCode: String,
        val birthDate: String?,
        val phoneNumber: String?
    )

    data class PatientListDTO(
        val patientList: List<PatientDTO>,
        val totalElements: Long,
        val totalPages: Int,
        val currentPage: Int,
        val pageSize: Int
    )
}
