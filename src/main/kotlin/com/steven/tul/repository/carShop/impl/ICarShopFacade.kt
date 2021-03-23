package com.steven.tul.repository.carShop.impl

import com.steven.tul.models.entity.CarShop
import com.steven.tul.models.entity.User
import java.util.*

interface ICarShopFacade {

    fun addCarShop(carShop: CarShop)
    fun findCarShop(user: User):Optional<CarShop>
    fun deleteByIdCar(idCar: UUID)
}
