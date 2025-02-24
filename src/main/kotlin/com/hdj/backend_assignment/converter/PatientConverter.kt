package com.hdj.backend_assignment.converter

import com.hdj.backend_assignment.domain.Hospital
import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.global.enums.SexCode
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO

class PatientConverter {

    companion object {

        fun toPatient(request: PatientRequestDTO.RegisterDTO, hospital: Hospital): Patient {
            return Patient(
                hospital = hospital,
                patientName = request.patientName,
                registrationNumber = request.registrationNumber,
                sexCode = SexCode.from(request.sexCode),
                birthDate = request.birthDate,
                phoneNumber = request.phoneNumber
            )
        }

        fun toRegisterResultDTO(patient:Patient): PatientResponseDTO.RegisterResultDTO {
            return PatientResponseDTO.RegisterResultDTO(
                patientId = patient.id,
                hospitalId = patient.hospital.id,
                patientName = patient.patientName,
                registrationNumber = patient.registrationNumber
            )
        }

        fun toGetResultDTO(patient: Patient): PatientResponseDTO.PatientDTO {
            return PatientResponseDTO.PatientDTO(
                patientId = patient.id,
                hospitalId = patient.hospital.id,
                patientName = patient.patientName,
                registrationNumber = patient.registrationNumber,
                sexCode = patient.sexCode.description,
                birthDate = patient.birthDate,
                phoneNumber = patient.phoneNumber,
                )
            }
    }
}