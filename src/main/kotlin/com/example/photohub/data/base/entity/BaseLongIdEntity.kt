package com.example.photohub.data.base.entity

import jakarta.persistence.*

@MappedSuperclass
open class BaseLongIdEntity(
    id: Long? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    var id: Long? = id
        protected set
}