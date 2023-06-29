package br.com.fiap.postech.fastfood.adapter.inbound.exception

import br.com.fiap.postech.fastfood.application.domain.exception.NotFoundEntityException
import br.com.fiap.postech.fastfood.application.domain.exception.ViolatesUniqueConstraintException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice() {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.localizedMessage
        )

        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(NotFoundEntityException::class)
    fun handleIllegalArgumentException(ex: NotFoundEntityException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.localizedMessage
        )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleIllegalArgumentException(ex: DataIntegrityViolationException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.localizedMessage
        )

        return ResponseEntity(erro, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ViolatesUniqueConstraintException::class)
    fun handleViolatesUniqueConstraintException(ex: ViolatesUniqueConstraintException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.localizedMessage
        )

        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handleEmptyResultDataAccessException(ex: EmptyResultDataAccessException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "Dados não encontrados"
        )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
}