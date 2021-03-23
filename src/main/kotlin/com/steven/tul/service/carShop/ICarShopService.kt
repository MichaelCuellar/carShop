package com.steven.tul.service.carShop

import com.steven.tul.commons.request.AddCarShopDto
import com.steven.tul.commons.response.Checkout
import com.steven.tul.commons.response.ResponseCar
import org.springframework.http.ResponseEntity
import java.util.*

interface ICarShopService {

    fun addCarShop(addCarShopDto: AddCarShopDto, idUser: Int): ResponseEntity<String>

    fun findCarShop(user: Int): ResponseEntity<ResponseCar>

    fun deleteDetail(idDetail: UUID): ResponseEntity<String>
    
    fun checkout(idUser: Int): ResponseEntity<Checkout>
}
