package com.hdj.backend_assignment.domain

import com.hdj.backend_assignment.domain.common.BaseEntity
import com.hdj.backend_assignment.global.enums.SexCode
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where

@Entity
@Table(name = "patient")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE patient SET deleted_at=CURRENT_TIMESTAMP WHERE id=?")
class Patient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital,

    var patientName: String,

    var registrationNumber: String,

    @Enumerated(EnumType.STRING)
    var sexCode: SexCode,

    var birthDate: String?,

    var phoneNumber: String?
): BaseEntity()
