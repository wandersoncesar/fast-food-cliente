package br.com.fiap.postech.fastfood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("br.com.fiap.postech.fastfood.*"))
@EnableJpaRepositories("br.com.fiap.postech.fastfood.*")
@EntityScan("br.com.fiap.postech.fastfood.*")
class FastFoodApplication

fun main(args: Array<String>) {
	runApplication<FastFoodApplication>(*args)
}