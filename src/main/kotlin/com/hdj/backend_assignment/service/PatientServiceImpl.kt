package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.converter.PatientConverter
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO
import org.springframework.stereotype.Service

@Service
class PatientServiceImpl : PatientService {
    override fun registerPatient(request: PatientRequestDTO.RegisterDTO): PatientResponseDTO.RegisterResultDTO {
        val patient = PatientConverter.toPatient(request)
        return PatientConverter.toRegisterResultDTO(patient)
    }
}