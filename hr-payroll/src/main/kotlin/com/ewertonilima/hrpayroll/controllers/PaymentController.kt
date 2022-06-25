package com.ewertonilima.hrpayroll.controllers

import com.ewertonilima.hrpayroll.models.Payment
import com.ewertonilima.hrpayroll.services.PaymentService
import com.ewertonilima.hrpayroll.services.implementations.PaymentServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(
        @PathVariable workerId: Long,
        @PathVariable days: Int
    ): ResponseEntity<Payment> {
        val payment: Payment = paymentService.getPayment(workerId, days)
        return ResponseEntity.ok(payment)
    }
}