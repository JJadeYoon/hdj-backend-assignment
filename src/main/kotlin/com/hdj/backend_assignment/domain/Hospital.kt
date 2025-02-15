package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.domain.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "hospital")
class Hospital(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var hospitalName: String,

    var medicalInstitutionNumber: String,

    var hospitalDirectorName: String
): BaseEntity()
