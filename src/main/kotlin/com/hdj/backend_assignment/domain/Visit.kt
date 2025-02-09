package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.global.enums.VisitStatusCode
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "visit")
class Visit(id: Long, hospital: Hospital, patient: Patient, visitDateTime: LocalDateTime, visitStatusCode: VisitStatusCode) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    val hospital: Hospital = hospital

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    val patient: Patient = patient

    @Column(nullable = false)
    val visitDateTime: LocalDateTime = visitDateTime

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    val visitStatusCode: VisitStatusCode = visitStatusCode
}