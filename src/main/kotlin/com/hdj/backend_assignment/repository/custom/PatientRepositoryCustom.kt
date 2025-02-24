package com.hdj.backend_assignment.repository.custom

import com.hdj.backend_assignment.domain.Patient
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PatientRepositoryCustom {

    fun searchPatient(
        patientName: String?,
        registrationNumber: String?,
        birthDate: String?,
        pageable: Pageable
    ): Page<Patient>
}