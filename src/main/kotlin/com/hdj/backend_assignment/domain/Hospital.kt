package com.hdj.backend_assignment.domain

import jakarta.persistence.*

@Entity
@Table(name = "hospital")
class Hospital(id: Long, hospitalName: String, medicalInstitutionNumber: String, hospitalDirectorName: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @Column(length = 45, nullable = false)
    val hospitalName: String = hospitalName

    @Column(length = 20, nullable = false)
    val medicalInstitutionNumber: String = medicalInstitutionNumber

    @Column(length = 10, nullable = false)
    var hospitalDirectorName: String = hospitalDirectorName
}