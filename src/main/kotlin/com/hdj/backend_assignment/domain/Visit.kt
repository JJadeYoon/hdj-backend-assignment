package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.domain.common.BaseEntity
import com.hdj.backend_assignment.global.enums.VisitStatusCode
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "visit")
class Visit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    var patient: Patient,

    var visitDateTime: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var visitStatusCode: VisitStatusCode
) : BaseEntity()
