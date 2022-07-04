package com.ewertonilima.hrpayroll

import com.ewertonilima.hrpayroll.loadbalancer.WorkerServerInstanceConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient
import org.springframework.cloud.openfeign.EnableFeignClients

@LoadBalancerClient(name = "hr-worker", configuration = [WorkerServerInstanceConfiguration::class])
@EnableFeignClients
@SpringBootApplication
class HrPayrollApplication

fun main(args: Array<String>) { 
	runApplication<HrPayrollApplication>(*args)
}
