package com.steven.tul.models.entity

import com.steven.tul.commons.enum.TypeProduct
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Product(
    @Id
    var id:UUID = UUID.randomUUID(),
    var name: String,
    var sku: Int,
    var description: String,
    var price: Int,
    var type: TypeProduct
)
