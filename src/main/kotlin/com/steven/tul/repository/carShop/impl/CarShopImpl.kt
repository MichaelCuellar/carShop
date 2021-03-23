package com.steven.tul.repository.carShop.impl

import com.steven.tul.commons.enum.TypeCarShop
import com.steven.tul.models.entity.CarShop
import com.steven.tul.models.entity.User
import com.steven.tul.repository.carShop.ICarShopRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarShopImpl: ICarShopFacade {

    @Autowired
    lateinit var iCarShopRepository: ICarShopRepository

    override fun addCarShop(carShop: CarShop) {
        iCarShopRepository.save(carShop)
    }

    override fun findCarShop(user: User): Optional<CarShop> {
        return iCarShopRepository.findByUserAndState(user,TypeCarShop.PENDIENTE)
    }

    override fun deleteByIdCar(idCar: UUID) {
        iCarShopRepository.deleteById(idCar)
    }
}
