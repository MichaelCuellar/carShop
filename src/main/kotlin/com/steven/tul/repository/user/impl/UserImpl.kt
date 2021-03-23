package com.steven.tul.repository.user.impl

import com.steven.tul.models.entity.User
import com.steven.tul.repository.user.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserImpl : IUserFacade {

    @Autowired
    lateinit var iUserRepository: IUserRepository

    override fun addUser(user: User) {
        iUserRepository.save(user)
    }

    override fun findById(user: Int): Optional<User> {
        return iUserRepository.findById(user)
    }

}
