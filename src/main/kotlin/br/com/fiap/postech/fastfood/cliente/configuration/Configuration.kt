package br.com.fiap.postech.fastfood.cliente.configuration

import br.com.fiap.postech.fastfood.cliente.adapter.gateway.*
import br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa.*
import br.com.fiap.postech.fastfood.cliente.domain.repository.*
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorCPFUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.BuscarClientePorIdUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.CadastrarClienteUseCase
import br.com.fiap.postech.fastfood.cliente.domain.usecase.cliente.ExcluirClienteUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class Configuration {

    @Bean
    fun clienteRepository(clienteRepositoryJpa: ClienteRepositoryJpa): ClienteRepository {
        return ClienteRepositoryImpl(clienteRepositoryJpa)
    }

    @Bean
    fun cadastrarClienteUseCase(clienteRepository: ClienteRepository): CadastrarClienteUseCase {
        return CadastrarClienteUseCase(clienteRepository)
    }

    @Bean
    fun buscarClientePorCPFUseCase(clienteRepository: ClienteRepository): BuscarClientePorCPFUseCase {
        return BuscarClientePorCPFUseCase(clienteRepository)
    }

    @Bean
    fun buscarClientePorIdUseCase(clienteRepository: ClienteRepository): BuscarClientePorIdUseCase {
        return BuscarClientePorIdUseCase(clienteRepository)
    }

    @Bean
    fun excluirClienteUseCase(clienteRepository: ClienteRepository): ExcluirClienteUseCase {
        return ExcluirClienteUseCase(clienteRepository)
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}