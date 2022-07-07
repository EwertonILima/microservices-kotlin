package com.ewertonilima.hrworker.controllers

import com.ewertonilima.hrworker.dto.WorkerDto
import com.ewertonilima.hrworker.services.WorkerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workers")
class WorkerController(
    private var workerService: WorkerService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<WorkerDto>> {
        val list = workerService.findAll()
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<WorkerDto> {
        val obj = workerService.findById(id)
        return ResponseEntity.ok(obj)
    }
}