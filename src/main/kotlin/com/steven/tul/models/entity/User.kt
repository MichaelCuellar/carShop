package com.steven.tul.models.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class User(
    @Id
    @Column(name = "id_user")
    var idUser: Int,
    var name: String
)
