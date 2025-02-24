package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO

interface PatientService {

    fun registerPatient(request: PatientRequestDTO.RegisterDTO): PatientResponseDTO.RegisterResultDTO

    fun getPatient(patientId: Long): PatientResponseDTO.PatientDTO

    fun updatePatient(patientId: Long, request: PatientRequestDTO.UpdateDTO): PatientResponseDTO.PatientDTO

    fun deletePatient(patientId: Long)

    fun searchPatient(request: PatientRequestDTO.SearchDTO): PatientResponseDTO.PatientListDTO
}
