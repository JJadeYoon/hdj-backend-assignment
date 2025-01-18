package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.global.enums.VisitStatusCode
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "visit")
class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    val hospital: Hospital? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    val patient: Patient? = null

    @Column(nullable = false)
    val visitDateTime: LocalDateTime? = null

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    val visitStatusCode: VisitStatusCode? = null
}