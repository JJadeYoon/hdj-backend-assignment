package com.hdj.backend_assignment.web.dto

class PatientRequestDTO {

    data class RegisterDTO(
        val id: Long,
        val hospitalId: Long,
        val patientName: String,
        val registrationNumber: String,
        val sexCode: String? = null,
        val birthDate: String? = null,
        val phoneNumber: String? = null
    )
}