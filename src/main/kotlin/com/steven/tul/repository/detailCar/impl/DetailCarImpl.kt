package com.steven.tul.repository.detailCar.impl

import com.steven.tul.repository.detailCar.IDetailCarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DetailCarImpl : IDetailCarFacade {

    @Autowired
    lateinit var iDetailCarRepository: IDetailCarRepository

    override fun existDetail(idCarDetail: UUID): Boolean {
        return iDetailCarRepository.existsById(idCarDetail)
    }

    override fun deleteDetail(idCarDetail: UUID) {
        iDetailCarRepository.deleteById(idCarDetail)
    }


}
