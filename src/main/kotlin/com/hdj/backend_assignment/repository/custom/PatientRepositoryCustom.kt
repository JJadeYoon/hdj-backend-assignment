package com.hdj.backend_assignment.repository.custom

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.web.dto.PatientRequestDTO.*
import org.springframework.data.domain.Page

interface PatientRepositoryCustom {

    fun searchPatient(
        searchDTO: SearchDTO
    ): Page<Patient>
}