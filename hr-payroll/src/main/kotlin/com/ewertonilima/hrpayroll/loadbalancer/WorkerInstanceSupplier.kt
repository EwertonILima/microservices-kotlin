package com.ewertonilima.hrpayroll.loadbalancer

import org.springframework.cloud.client.DefaultServiceInstance
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier
import reactor.core.publisher.Flux


class WorkerInstanceSupplier(
    private val serviceId: String
) : ServiceInstanceListSupplier {

    override fun getServiceId(): String {
        return serviceId
    }

    override fun get(): Flux<List<
            ServiceInstance>> {
        return Flux.just(
            listOf(
                DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8001, false),
                DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8002, false)
            )
        )

    }
}