package com.steven.tul


import com.steven.tul.commons.enum.TypeProduct
import com.steven.tul.models.entity.Product
import com.steven.tul.models.entity.User
import com.steven.tul.repository.product.impl.IProductFacade
import com.steven.tul.repository.user.impl.IUserFacade
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*



@Configuration
class TulConfiguration : WebMvcConfigurer {

    @Bean
    fun databaseInitializer(iProductFacade: IProductFacade, iUserFacade: IUserFacade) =
        ApplicationRunner {
            iUserFacade.addUser(User(159, "Pedro"))
            iUserFacade.addUser(User(278, "Antonio"))

            iProductFacade.addProduct(
                Product(
                    UUID.randomUUID(), "Pintura", 120, "Para uso en la casa", 80, TypeProduct.DESCUENTO
                )
            )

            iProductFacade.addProduct(
                Product(
                    UUID.randomUUID(), "Madera", 145, "Distintos uso", 150, TypeProduct.SIMPLE
                )
            )

            iProductFacade.addProduct(
                Product(
                    UUID.randomUUID(), "Tornillos", 165, "para el hogar", 180, TypeProduct.DESCUENTO
                )
            )

            iProductFacade.addProduct(
                Product(
                    UUID.randomUUID(), "Pegante", 185, "Para usar con madera", 250, TypeProduct.SIMPLE
                )
            )
        }
}


