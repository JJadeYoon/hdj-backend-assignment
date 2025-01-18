package com.hdj.backend_assignment.domain

import jakarta.persistence.*

@Entity
@Table(name = "hospital")
class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(length = 45, nullable = false)
    val hospitalName: String? = null

    @Column(length = 20, nullable = false)
    val medicalInstitutionNumber: String? = null

    @Column(length = 10, nullable = false)
    var hospitalDirectorName: String? = null
}