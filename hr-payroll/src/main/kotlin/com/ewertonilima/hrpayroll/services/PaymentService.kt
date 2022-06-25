package com.ewertonilima.hrpayroll.services

import com.ewertonilima.hrpayroll.models.Payment

interface PaymentService {

    fun getPayment(workerId: Long, days: Int): Payment
}