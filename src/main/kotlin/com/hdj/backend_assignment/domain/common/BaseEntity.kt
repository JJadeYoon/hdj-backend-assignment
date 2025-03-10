package com.hdj.backend_assignment.domain.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.SoftDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {
    @CreatedDate
    val createdAt: LocalDateTime? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
}
