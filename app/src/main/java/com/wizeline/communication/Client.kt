package com.wizeline.communication

data class Client(
    val id: String = "",
    var name: String = "",
    val creditRating: CreditRating = CreditRating.C_LESS
)
