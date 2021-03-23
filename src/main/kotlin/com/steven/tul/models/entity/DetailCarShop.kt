package com.steven.tul.models.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "detail_car_shop")
data class DetailCarShop(
    @Id
    @Column(name = "id_detail_car_shop")
    var idDetailCarShop: UUID? = UUID.randomUUID(),
    var quantity: Int? = null,
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "FK_CAR_SHOP", nullable = false)
    var carShop: CarShop? = null,
    @ManyToOne
    var product: Product? = null
)
