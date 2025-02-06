package com.hdj.backend_assignment.repository

import com.hdj.backend_assignment.domain.Hospital
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HospitalRepository: JpaRepository<Hospital, Long> {
}