package com.ewertonilima.hrpayroll.services

import com.ewertonilima.hrpayroll.models.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService() {

    fun getPayment(workerId: Long, days: Int): Payment {
        return Payment("Bob", 200.0, days)
    }
}