package com.ewertonilima.hrpayroll.controllers.exceptions

import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class FeignStatusExceptionHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler
    fun handleFeignStatusException(e: FeignException, request: HttpServletRequest): ResponseEntity<StandardError> {
        logger.error(e.contentUTF8().toString())
        val err = StandardError(
            LocalDateTime.now(),
            e.status(),
            e.contentUTF8(),
            request.requestURI
        )
        return ResponseEntity.status(e.status()).body(err)
    }
}