package com.ewertonilima.hrpayroll.feignclients

import com.ewertonilima.hrpayroll.models.Worker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(name = "hr-worker", path = "/workers")
interface WorkerFeignClient {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Worker>
}