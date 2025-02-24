package com.hdj.backend_assignment.repository.custom

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.domain.QPatient.patient
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
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
        val query = queryFactory
            .selectFrom(patient)
            .where(
                patientNameEq(patientName),
                registrationNumberEq(registrationNumber),
                birthDateEq(birthDate)
            )
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())

        pageable.sort.forEach { order ->
            if (order.isAscending) {
                when (order.property) {
                    "patientName" -> query.orderBy(patient.patientName.asc())
                    "registrationNumber" -> query.orderBy(patient.registrationNumber.asc())
                    "birthDate" -> query.orderBy(patient.birthDate.asc())
                    else -> query.orderBy(patient.id.asc())
                }
            } else {
                when (order.property) {
                    "patientName" -> query.orderBy(patient.patientName.desc())
                    "registrationNumber" -> query.orderBy(patient.registrationNumber.desc())
                    "birthDate" -> query.orderBy(patient.birthDate.desc())
                    else -> query.orderBy(patient.id.desc())
                }
            }
        }

        val fetch = query.fetch()

        return PageImpl(
            fetch,
            pageable,
            fetch.count().toLong()
        )
    }

    private fun patientNameEq(patientName: String?): BooleanExpression? {
        return patientName?.let { patient.patientName.eq(it) }
    }

    private fun registrationNumberEq(registrationNumber: String?): BooleanExpression? {
        return registrationNumber?.let { patient.registrationNumber.eq(it) }
    }

    private fun birthDateEq(birthDate: String?): BooleanExpression? {
        return birthDate?.let { patient.birthDate.eq(it) }
    }
}
