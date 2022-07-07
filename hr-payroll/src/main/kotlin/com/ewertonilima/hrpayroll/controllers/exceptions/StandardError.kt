package com.ewertonilima.hrpayroll.controllers.exceptions

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDateTime


data class StandardError(
    val timestamp: LocalDateTime,
    val status: Int,
    @JsonProperty("error-message")
    val errorMessage: String,
    val path: String?
) : Serializable
