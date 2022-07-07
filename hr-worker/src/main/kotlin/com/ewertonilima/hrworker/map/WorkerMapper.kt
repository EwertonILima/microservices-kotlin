package com.ewertonilima.hrworker.map

import com.ewertonilima.hrworker.dto.WorkerDto
import com.ewertonilima.hrworker.models.Worker

fun mapToWorkerDto(entity: Worker) = WorkerDto(
    id = entity.id,
    name = entity.name,
    dailyIncome = entity.dailyIncome
)