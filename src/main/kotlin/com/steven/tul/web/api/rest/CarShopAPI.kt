package com.steven.tul.web.api.rest

import com.steven.tul.commons.request.AddCarShopDto
import com.steven.tul.commons.response.Checkout
import com.steven.tul.commons.response.ResponseCar
import com.steven.tul.service.carShop.ICarShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["*"])
class CarShopAPI {

    @Autowired
    lateinit var iCarShopService: ICarShopService

    @PostMapping("/car/{idUser}")
    fun addCar(@RequestBody addCarShopDto: AddCarShopDto,@PathVariable idUser: Int): ResponseEntity<String> {
        return iCarShopService.addCarShop(addCarShopDto,idUser)
    }

    @GetMapping("/car/{idUser}")
    fun findCar(@PathVariable idUser: Int): ResponseEntity<ResponseCar> {
        return iCarShopService.findCarShop(idUser)
    }

    @DeleteMapping("/car/{idDetail}")
    fun deleteDetailCar(@PathVariable idDetail : UUID) : ResponseEntity<String>{
        return iCarShopService.deleteDetail(idDetail)
    }

    @GetMapping("/car/{idUser}/checkout")
    fun checkout(@PathVariable idUser: Int) : ResponseEntity<Checkout>{
        return iCarShopService.checkout(idUser)
    }
}
