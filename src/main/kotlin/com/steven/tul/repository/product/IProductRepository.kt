package com.steven.tul.repository.product

import com.steven.tul.models.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IProductRepository : JpaRepository<Product,UUID>{

    fun existsBySku(sku:Int): Boolean
    fun findBySku(sku: Int): Optional<Product>

}
