package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.web.dto.PatientRequestDTO

interface PatientService {
    fun registerPatient(request: PatientRequestDTO.RegisterDTO): Patient
}