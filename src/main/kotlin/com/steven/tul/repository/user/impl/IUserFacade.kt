package com.steven.tul.repository.user.impl

import com.steven.tul.models.entity.User
import java.util.*

interface IUserFacade {

    fun addUser(user:User)

    fun findById(user : Int): Optional<User>
}
