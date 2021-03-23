package com.steven.tul.service.product

import com.steven.tul.commons.exception.ConflictException
import com.steven.tul.commons.exception.NotFoundException
import com.steven.tul.models.entity.Product
import com.steven.tul.repository.product.impl.IProductFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService : IProductService {

    @Autowired
    lateinit var iProductFacade: IProductFacade;

    override fun addProduct(product: Product): ResponseEntity<String> {
        if (iProductFacade.existsProduct(product.sku))
            throw ConflictException(product.sku)
        iProductFacade.addProduct(product)
        return ResponseEntity(HttpStatus.CREATED)
    }

    override fun listProduct(): List<Product> {
        return iProductFacade.listProduct()
    }

    override fun updateProduct(product: Product): ResponseEntity<String> {
        val productTmp: Optional<Product> = iProductFacade.findProductBySku(product.sku)
        if(productTmp.isPresent)
            product.id = productTmp.get().id
        else
            throw NotFoundException()
        iProductFacade.addProduct(product)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteProduct(sku: Int): ResponseEntity<String> {
        val product: Optional<Product> = iProductFacade.findProductBySku(sku)
        if(!product.isPresent)
            throw NotFoundException()
        iProductFacade.deleteProduct(product.get().id)
        return ResponseEntity(HttpStatus.OK)
    }


}
