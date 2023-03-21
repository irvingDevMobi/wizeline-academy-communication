package com.wizeline.communication

enum class CreditRating {
    A_PLUS,
    A_LESS,
    B_PLUS,
    B_LESS,
    C_PLUS,
    C_LESS;

    override fun toString(): String = when (this) {
        A_PLUS -> A_PLUS_LABEL
        A_LESS -> A_LESS_LABEL
        B_PLUS -> B_PLUS_LABEL
        B_LESS -> B_LESS_LABEL
        C_PLUS -> C_PLUS_LABEL
        C_LESS -> C_LESS_LABEL
    }

    companion object {
        fun fromString(label: String?): CreditRating = when (label) {
            A_PLUS_LABEL -> A_PLUS
            A_LESS_LABEL -> A_LESS
            B_PLUS_LABEL -> B_PLUS
            B_LESS_LABEL -> B_LESS
            C_PLUS_LABEL -> C_PLUS
            else -> C_LESS
        }

        private const val A_PLUS_LABEL = "A+"
        private const val A_LESS_LABEL = "A-"
        private const val B_PLUS_LABEL = "B+"
        private const val B_LESS_LABEL = "B-"
        private const val C_PLUS_LABEL = "C+"
        private const val C_LESS_LABEL = "C-"
    }
}
