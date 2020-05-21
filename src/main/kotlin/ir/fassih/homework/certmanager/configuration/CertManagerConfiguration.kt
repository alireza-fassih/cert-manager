package ir.fassih.homework.certmanager.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import ir.fassih.homework.certmanager.service.CustomUserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.access.AccessDeniedHandler
import java.io.IOException
import java.io.OutputStream
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
class ApplicationContext {

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}


@Configuration
class CustomWebSecurityConfiguration : WebSecurityConfigurerAdapter() {


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
                .antMatchers("/admin/**")
                    .authenticated()
            .and()
            .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
            .and()
            .formLogin()
                .disable();
    }

    @Autowired
    @Throws(Exception::class)
    fun configGlobal(builder: AuthenticationManagerBuilder,
                     userManager: CustomUserDetailService,
                     encoder: BCryptPasswordEncoder) {
        builder.userDetailsService<UserDetailsService>(userManager).passwordEncoder(encoder)
    }

}



class RestAccessDeniedHandler : AccessDeniedHandler {

    @Throws(IOException::class, ServletException::class)
    override fun handle(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, e: org.springframework.security.access.AccessDeniedException) {
        val response = ApiResponse(403, "Access Denied")
        val out: OutputStream = httpServletResponse.outputStream
        val mapper = ObjectMapper()
        mapper.writeValue(out, response)
        out.flush()
    }

}


class ApiResponse(
    var status: Int,
    var message: String
)