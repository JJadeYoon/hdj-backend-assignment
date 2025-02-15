package com.hdj.backend_assignment.service

import com.hdj.backend_assignment.converter.PatientConverter
import com.hdj.backend_assignment.converter.PatientConverter.Companion.toRegisterResultDTO
import com.hdj.backend_assignment.repository.HospitalRepository
import com.hdj.backend_assignment.repository.PatientRepository
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO
import org.springframework.stereotype.Service

@Service
class PatientServiceImpl(
    private val patientRepository: PatientRepository,
    private val hospitalRepository: HospitalRepository
) : PatientService{
    override fun registerPatient(request: PatientRequestDTO.RegisterDTO): PatientResponseDTO.RegisterResultDTO {

        val hospitalId = request.hospitalId
        val hospital = hospitalRepository.findById(hospitalId)
            .orElseThrow()

        val patient = PatientConverter.toPatient(request, hospital)

        return toRegisterResultDTO(patientRepository.save(patient))
    }
}