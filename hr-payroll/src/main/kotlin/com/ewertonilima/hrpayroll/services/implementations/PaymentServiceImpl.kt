package com.ewertonilima.hrpayroll.services.implementations

import com.ewertonilima.hrpayroll.feignclients.WorkerFeignClient
import com.ewertonilima.hrpayroll.models.Payment
import com.ewertonilima.hrpayroll.services.PaymentService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(
    private val workerFeignClient: WorkerFeignClient
) : PaymentService {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun getPayment(workerId: Long, days: Int): Payment {

        logger.info("Searching payment by id [$workerId]")

        val worker = workerFeignClient.findById(workerId).body
        return Payment(worker!!.name, worker.dailyIncome, days)
    }
}
