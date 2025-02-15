package com.hdj.backend_assignment.web.dto

class PatientRequestDTO {

    data class RegisterDTO(
        val id: Long,
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
}