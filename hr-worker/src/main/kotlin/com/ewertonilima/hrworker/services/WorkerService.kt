package com.ewertonilima.hrworker.services

import com.ewertonilima.hrworker.dto.WorkerDto

interface WorkerService {

    fun findAll(): List<WorkerDto>

    fun findById(id: Long): WorkerDto
}