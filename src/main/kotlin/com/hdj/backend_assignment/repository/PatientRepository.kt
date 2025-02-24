package com.hdj.backend_assignment.repository

import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.repository.custom.PatientRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository :
    JpaRepository<Patient, Long>,
    QuerydslPredicateExecutor<Patient>,
    PatientRepositoryCustom