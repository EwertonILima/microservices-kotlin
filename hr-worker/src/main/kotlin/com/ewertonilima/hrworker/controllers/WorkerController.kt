package com.ewertonilima.hrworker.controllers

import com.ewertonilima.hrworker.dto.WorkerDto
import com.ewertonilima.hrworker.services.implementations.WorkerServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workers")
class WorkerController(
    private var workerServiceImpl: WorkerServiceImpl
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<WorkerDto>> {
        val list = workerServiceImpl.findAll()
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<WorkerDto> {
        val obj = workerServiceImpl.findById(id)
        return ResponseEntity.ok(obj)
    }
}