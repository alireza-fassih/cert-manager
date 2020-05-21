package ir.fassih.homework.certmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class CertManagerApplication

fun main(args: Array<String>) {
	runApplication<CertManagerApplication>(*args)
}


