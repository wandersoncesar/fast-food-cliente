package br.com.fiap.postech.fastfood.application.ports.interfaces

import br.com.fiap.postech.fastfood.application.domain.dtos.PagamentoDTO

interface PagamentoServicePort {

    fun efetuaPagamento(pagamentoDTO: PagamentoDTO): PagamentoDTO
}