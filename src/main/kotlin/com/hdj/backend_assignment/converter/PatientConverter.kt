package com.hdj.backend_assignment.converter

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO

class PatientConverter {
    companion object {
        fun toRegisterResultDTO(patient:Patient): PatientResponseDTO.RegisterResultDTO {
            TODO()
        }

        fun toPatient(request: PatientRequestDTO.RegisterDTO): Patient {
            TODO()
        }
    }
}