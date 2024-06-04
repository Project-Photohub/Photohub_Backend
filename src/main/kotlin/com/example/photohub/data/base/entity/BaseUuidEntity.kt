package com.example.photohub.data.base.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.*

@MappedSuperclass
open class BaseUuidEntity(
    id: UUID?
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    var id: UUID? = id
        protected set
}