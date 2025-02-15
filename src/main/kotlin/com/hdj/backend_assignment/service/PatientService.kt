package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO

interface PatientService {
    fun registerPatient(request: PatientRequestDTO.RegisterDTO): PatientResponseDTO.RegisterResultDTO
}