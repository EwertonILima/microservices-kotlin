package com.ewertonilima.hrworker.services.implementations

import com.ewertonilima.hrworker.dto.WorkerDto
import com.ewertonilima.hrworker.map.mapToWorkerDto
import com.ewertonilima.hrworker.models.Worker
import com.ewertonilima.hrworker.repositories.WorkerRepository
import com.ewertonilima.hrworker.services.WorkerService
import com.ewertonilima.hrworker.services.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.logging.Logger
import java.util.stream.Collectors

@Service
class WorkerServiceImpl(
    private val workerRepository: WorkerRepository
) : WorkerService {

    private val logger: Logger = Logger.getLogger("Log information")

    @Transactional(readOnly = true)
    override fun findAll(): List<WorkerDto> {
        logger.info("Searching all workers")
        val list = workerRepository.findAll()
        return list.stream().map { mapToWorkerDto(it) }.collect(Collectors.toList())
    }


    @Transactional(readOnly = true)
    override fun findById(id: Long): WorkerDto {
        logger.info("Searching worker by id $id")
        val obj: Optional<Worker> = workerRepository.findById(id)
        val entity: Worker = obj.orElseThrow {
            ResourceNotFoundException(
                "Id $id not found"
            )
        }
        return mapToWorkerDto(entity)
    }
}