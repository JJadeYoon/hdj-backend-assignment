package com.hdj.backend_assignment.repository.custom

import com.hdj.backend_assignment.domain.Patient
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class PatientRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : PatientRepositoryCustom {
    override fun searchPatient(
        patientName: String?,
        registrationNumber: String?,
        birthDate: String?,
        pageable: Pageable
    ): Page<Patient> {
        TODO()
    }
}
