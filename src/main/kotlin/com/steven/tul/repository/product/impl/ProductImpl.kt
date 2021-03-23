package com.steven.tul.repository.product.impl

import com.steven.tul.models.entity.Product
import com.steven.tul.repository.product.IProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductImpl:IProductFacade {

    @Autowired
    lateinit var productRepository: IProductRepository

    override fun addProduct(product: Product): Product {
        return productRepository.save(product)
    }


    override fun listProduct(): List<Product> {
        return productRepository.findAll()
    }

    override fun existsProduct(sku: Int): Boolean {
        return productRepository.existsBySku(sku)
    }

    override fun findProductBySku(sku: Int): Optional<Product> {
        return productRepository.findBySku(sku)
    }

    override fun deleteProduct(id: UUID) {
        productRepository.deleteById(id)
    }
}
