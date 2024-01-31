package com.degreemanagement.model.degree

data class Degree(
    val value: Int,
    val subject: String
) {
    companion object {
        fun fromString(string: String): Degree {
            val (value, subject) = string.split(":")
            return Degree(value.toInt(), subject)
        }
    }

    override fun toString(): String {
        return "$value:$subject"
    }
}