package com.ewertonilima.hrworker.controllers.exceptions

import com.ewertonilima.hrworker.services.exceptions.ResourceNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ResourceExceptionHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler
    fun entityNotFound(e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        logger.error(e.message)
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(
                LocalDateTime.now(),
                status.value(),
                "Resource Not Found",
                e.message,
                request.requestURI
        )
        return ResponseEntity.status(status).body(err)
    }
}