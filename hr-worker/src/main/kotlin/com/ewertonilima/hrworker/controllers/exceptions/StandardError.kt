package com.ewertonilima.hrworker.controllers.exceptions

import java.io.Serializable
import java.time.LocalDateTime


data class StandardError(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String?,
    val path: String?
) : Serializable
