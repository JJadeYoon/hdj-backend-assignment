package com.hdj.backend_assignment.repository

import com.hdj.backend_assignment.domain.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository: JpaRepository<Patient, Long> {
}