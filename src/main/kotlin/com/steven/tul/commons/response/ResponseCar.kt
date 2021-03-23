package com.steven.tul.commons.response

import com.steven.tul.commons.enum.TypeCarShop
import com.steven.tul.models.entity.User
import java.util.*


data class ResponseCar(

    var idCarShop: UUID = UUID.randomUUID(),
    var user: User? = null,
    var detailCarShops: MutableList<DetailCar>? = null,
    var state: TypeCarShop? = null
)

