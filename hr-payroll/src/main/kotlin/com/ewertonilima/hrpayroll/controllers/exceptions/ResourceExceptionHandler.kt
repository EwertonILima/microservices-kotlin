package com.ewertonilima.hrpayroll.controllers.exceptions

import com.ewertonilima.hrpayroll.services.execeptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler
    fun entityNotFound(e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
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