package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.global.enums.SexCode
import jakarta.persistence.*

@Entity
@Table(name = "patient")
class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital? = null

    @Column(length = 45, nullable = false)
    val patientName: String? = null

    @Column(length = 13, nullable = false)
    val registrationNumber: String? = null

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    val sexCode: SexCode? = null

    @Column(length = 10, nullable = false)
    val birthDate: String? = null

    @Column(length = 20, nullable = false)
    var phoneNumber: String? = null
}