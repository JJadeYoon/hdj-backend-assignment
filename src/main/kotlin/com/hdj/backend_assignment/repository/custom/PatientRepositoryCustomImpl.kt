package com.hdj.backend_assignment.repository.custom

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.web.dto.PatientRequestDTO.*
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page

class PatientRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : PatientRepositoryCustom {
    override fun searchPatient(
        searchDTO: SearchDTO
    ): Page<Patient> {
        TODO()
    }
}
