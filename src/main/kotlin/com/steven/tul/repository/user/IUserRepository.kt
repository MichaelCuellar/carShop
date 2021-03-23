package com.steven.tul.repository.user

import com.steven.tul.models.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository: JpaRepository<User, Int> {
}
