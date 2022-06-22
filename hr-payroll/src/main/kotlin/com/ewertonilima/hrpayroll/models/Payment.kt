package com.ewertonilima.hrpayroll.models

data class Payment(
    val name: String,
    val dailyIncome: Double,
    val days: Int
) {
    fun getTotal(): Double {
        return days * dailyIncome
    }
}