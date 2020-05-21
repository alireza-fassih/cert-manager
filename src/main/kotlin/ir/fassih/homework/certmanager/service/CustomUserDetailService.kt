package ir.fassih.homework.certmanager.service

import ir.fassih.homework.certmanager.repo.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.collections.HashSet


@Service
class CustomUserDetailService ( val userRepository: UserRepository ): UserDetailsService {

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!) ?: throw UsernameNotFoundException(username)
        return User(user.username, user.password, HashSet())
    }

}