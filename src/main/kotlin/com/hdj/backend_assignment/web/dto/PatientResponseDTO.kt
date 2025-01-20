package com.hdj.backend_assignment.web.dto

class PatientResponseDTO {

    data class RegisterResultDTO(
        val patientId: Long,
        val hospitalId: Long,
        val patientName: String,
        val registrationNumber: String
    )
}