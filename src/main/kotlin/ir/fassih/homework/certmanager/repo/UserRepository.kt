package ir.fassih.homework.certmanager.repo

import ir.fassih.homework.certmanager.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(userName: String) : UserEntity?

}