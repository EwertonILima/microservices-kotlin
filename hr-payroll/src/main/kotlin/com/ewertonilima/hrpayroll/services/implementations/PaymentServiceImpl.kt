package com.ewertonilima.hrpayroll.services.implementations

import com.ewertonilima.hrpayroll.models.Payment
import com.ewertonilima.hrpayroll.models.Worker
import com.ewertonilima.hrpayroll.services.PaymentService
import com.ewertonilima.hrpayroll.services.execeptions.ResourceNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.client.RestTemplate

@Service
class PaymentServiceImpl(
        private val restTemplate: RestTemplate
) : PaymentService {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Value("\${hr-worker.host}")
    private var workerHost: String = String()

    override fun getPayment(workerId: Long, days: Int): Payment {
        try {

            logger.info("Searching payment by id [$workerId]")
            val uriVariables = HashMap<String, String>()
            uriVariables["id"] = workerId.toString()

            val worker = restTemplate.getForObject(
                    "$workerHost/workers/{id}",
                    Worker::class.java,
                    uriVariables
            )
            return Payment(worker!!.name, worker.dailyIncome, days)
        } catch (e: RestClientResponseException) {
            if (e.rawStatusCode == "404".toInt()) {
                logger.error(e.localizedMessage)
                throw ResourceNotFoundException("Worker Id [$workerId] Not Found")
            } else {
                logger.error(e.localizedMessage)
                throw RuntimeException(e)
            }
        }
    }
}