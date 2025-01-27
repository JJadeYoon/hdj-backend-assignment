package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.global.enums.SexCode
import jakarta.persistence.*

@Entity
@Table(name = "patient")
class Patient(id: Long, hospital: Hospital, patientName: String, registrationNumber: String, sexCode: SexCode) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital = hospital

    @Column(length = 45, nullable = false)
    val patientName: String = patientName

    @Column(length = 13, nullable = false)
    val registrationNumber: String = registrationNumber

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = true)
    val sexCode: SexCode = sexCode

    @Column(length = 10, nullable = true)
    val birthDate: String? = null

    @Column(length = 20, nullable = true)
    var phoneNumber: String? = null
}