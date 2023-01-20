package net.ngaspar.urlshortener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("net.ngaspar.urlshortener")
@EnableJpaRepositories
class UrlshortenerApplication

fun main(args: Array<String>) {
	runApplication<UrlshortenerApplication>(*args)
}
