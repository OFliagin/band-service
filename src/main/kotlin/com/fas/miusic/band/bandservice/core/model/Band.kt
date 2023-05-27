package com.fas.miusic.band.bandservice.core.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "band")
class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false, length = 50)
    val name: String? = null

    @Column(name = "description", length = 250)
    private val description: String? = null

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    val updateDate: LocalDateTime? = null

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    val createDate: LocalDateTime? = null

    @Column(name = "adress_id")
    val adressId: Long? = null

    @Column(name = "deleted", nullable = false)
    val deleted = false
}
