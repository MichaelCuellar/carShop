package com.steven.tul.repository.detailCar

import com.steven.tul.models.entity.DetailCarShop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IDetailCarRepository : JpaRepository<DetailCarShop, UUID>
