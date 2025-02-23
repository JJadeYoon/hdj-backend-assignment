package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.web.dto.PageResponseDTO
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO

interface PatientService {

    fun registerPatient(request: PatientRequestDTO.RegisterDTO): PatientResponseDTO.RegisterResultDTO

    fun getPatient(patientId: Long): PatientResponseDTO.GetResultDTO

    fun updatePatient(patientId: Long, request: PatientRequestDTO.UpdateDTO): PatientResponseDTO.GetResultDTO

    fun deletePatient(patientId: Long)

    fun searchPatient(request: PatientRequestDTO.SearchDTO): PageResponseDTO.PageResponse<PatientResponseDTO.GetResultDTO>
}
