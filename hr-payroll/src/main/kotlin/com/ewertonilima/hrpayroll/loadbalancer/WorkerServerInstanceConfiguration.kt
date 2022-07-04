package com.ewertonilima.hrpayroll.loadbalancer

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WorkerServerInstanceConfiguration {

    @Bean
    fun serviceInstanceListSupplier(): ServiceInstanceListSupplier {
        return WorkerInstanceSupplier("hr-worker")
    }
}