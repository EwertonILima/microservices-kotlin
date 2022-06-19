package com.ewertonilima.hrworker.repositories

import com.ewertonilima.hrworker.models.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository : JpaRepository<Worker, Long> {
}