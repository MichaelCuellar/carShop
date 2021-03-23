package com.steven.tul.repository.detailCar.impl

import java.util.*

interface IDetailCarFacade {

    fun existDetail(idCarDetail: UUID): Boolean
    fun deleteDetail(idCarDetail: UUID)
}
