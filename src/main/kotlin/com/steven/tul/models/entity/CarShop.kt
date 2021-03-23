package com.steven.tul.models.entity

import com.steven.tul.commons.enum.TypeCarShop
import java.util.*
import javax.persistence.*;


@Entity
@Table(name = "car_shop")
data class CarShop(

    @Id
    @Column(name = "id_car_shop")
    var idCarShop: UUID = UUID.randomUUID(),
    @ManyToOne
    var user: User? = null,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "carShop")
    var detailCarShops: MutableList<DetailCarShop>? = null,
    var state: TypeCarShop? = TypeCarShop.PENDIENTE
)
