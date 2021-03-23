package com.steven.tul.commons.response

import com.steven.tul.models.entity.Product
import java.util.*


data class DetailCar (
    var idDetailCarShop: UUID? = null,
    var quantity: Int? = null,
    var product: Product? = null
)
