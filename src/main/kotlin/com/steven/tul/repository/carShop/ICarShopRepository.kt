package com.steven.tul.repository.carShop

import com.steven.tul.commons.enum.TypeCarShop
import com.steven.tul.models.entity.CarShop
import com.steven.tul.models.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ICarShopRepository : JpaRepository<CarShop, UUID> {
    fun findByUserAndState(user: User,state:TypeCarShop) : Optional<CarShop>
}
