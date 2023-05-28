package com.fas.miusic.band.bandservice.core.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "band")
data class Band(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null,

    @Column(name = "description", length = 250)
    var description: String? = null,

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @Column(name = "adress_id")
    var adressId: Long? = null,

    @Column(name = "deleted", nullable = false)
    var deleted : Boolean = false
) {

constructor(name: String?, description: String?, adressId: Long?) : this(null, name, description, null, null, adressId, false)

    }
