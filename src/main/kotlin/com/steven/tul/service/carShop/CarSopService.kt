package com.steven.tul.service.carShop

import com.steven.tul.commons.enum.TypeCarShop
import com.steven.tul.commons.enum.TypeProduct
import com.steven.tul.commons.exception.NotFoundException
import com.steven.tul.commons.request.AddCarShopDto
import com.steven.tul.commons.response.Checkout
import com.steven.tul.commons.response.DetailCar
import com.steven.tul.commons.response.ResponseCar
import com.steven.tul.models.entity.CarShop
import com.steven.tul.models.entity.DetailCarShop
import com.steven.tul.models.entity.Product
import com.steven.tul.models.entity.User
import com.steven.tul.repository.carShop.impl.ICarShopFacade
import com.steven.tul.repository.detailCar.impl.IDetailCarFacade
import com.steven.tul.repository.product.impl.IProductFacade
import com.steven.tul.repository.user.impl.IUserFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarSopService : ICarShopService {

    @Autowired
    lateinit var iUserFacade: IUserFacade

    @Autowired
    lateinit var iCarShopFacade: ICarShopFacade

    @Autowired
    lateinit var iProductFacade: IProductFacade

    @Autowired
    lateinit var iDetailCarFacade: IDetailCarFacade

    override fun addCarShop(addCarShopDto: AddCarShopDto, idUser: Int): ResponseEntity<String> {
        val user: Optional<User> = iUserFacade.findById(idUser)
        if (!user.isPresent)
            return ResponseEntity(HttpStatus.CONFLICT)
        val product: Optional<Product> = iProductFacade.findProductBySku(addCarShopDto.sku)
        if (!product.isPresent)
            return ResponseEntity(HttpStatus.CONFLICT)
        val carShopDto: Optional<CarShop> = iCarShopFacade.findCarShop(user.get())
        val detailCarShop = DetailCarShop()
        val detailCarShopsList: MutableList<DetailCarShop> = mutableListOf()
        return if (carShopDto.isPresent) {
            var status = true
            for (i in carShopDto.get().detailCarShops?.indices!!) {
                if (carShopDto.get().detailCarShops!![i].product?.sku == addCarShopDto.sku) {
                    carShopDto.get().detailCarShops!![i].quantity = addCarShopDto.quantity
                    status = false
                }
            }
            if (status) {
                detailCarShop.carShop = carShopDto.get()
                detailCarShop.quantity = addCarShopDto.quantity
                detailCarShop.product = product.get()

                detailCarShopsList.add(detailCarShop)
                carShopDto.get().detailCarShops!!.addAll(detailCarShopsList)

            }
            iCarShopFacade.addCarShop(carShopDto.get())
            ResponseEntity(HttpStatus.OK)
        } else {
            val carShop = CarShop()

            detailCarShop.carShop = carShop
            detailCarShop.product = product.get()
            detailCarShop.quantity = addCarShopDto.quantity
            detailCarShopsList.add(detailCarShop)
            carShop.detailCarShops = detailCarShopsList
            carShop.user = user.get()
            iCarShopFacade.addCarShop(carShop)

            ResponseEntity(HttpStatus.OK)
        }

    }

    override fun findCarShop(user: Int): ResponseEntity<ResponseCar> {
        val carShop = iCarShopFacade.findCarShop(iUserFacade.findById(user).get())
        if (carShop.isPresent)
            return ResponseEntity(changeCar(carShop.get()), HttpStatus.OK)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteDetail(idDetail: UUID): ResponseEntity<String> {
        if (!iDetailCarFacade.existDetail(idDetail))
            throw NotFoundException()
        iDetailCarFacade.deleteDetail(idDetail)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun checkout(idUser: Int): ResponseEntity<Checkout> {
        val user: Optional<User> = iUserFacade.findById(idUser)
        if (!user.isPresent)
            return ResponseEntity(HttpStatus.CONFLICT)
        val carShopDto: Optional<CarShop> = iCarShopFacade.findCarShop(user.get())
        if (!carShopDto.isPresent)
            return ResponseEntity(HttpStatus.CONFLICT)
        var total = 0
        for (item in carShopDto.get().detailCarShops!!) {
            total += if (item.product!!.type == TypeProduct.DESCUENTO)
                item.quantity!! * (item.product!!.price / 2)
            else
                item.quantity!! * item.product!!.price
        }
        carShopDto.get().state = TypeCarShop.COMPLETADO
        iCarShopFacade.addCarShop(carShopDto.get())
        return ResponseEntity(Checkout(total), HttpStatus.OK)

    }

    fun changeCar(carShop: CarShop): ResponseCar {
        val responseCar = ResponseCar()
        responseCar.idCarShop = carShop.idCarShop
        responseCar.user = carShop.user
        responseCar.state = carShop.state
        val detailList: MutableList<DetailCar> = mutableListOf()

        for (item in carShop.detailCarShops!!) {
            val detail = DetailCar()
            detail.idDetailCarShop = item.idDetailCarShop
            detail.product = item.product
            detail.quantity = item.quantity

            detailList.add(detail)
        }

        responseCar.detailCarShops = detailList

        return responseCar
    }
}
