package com.degreemanagement.data

import android.content.SharedPreferences
import com.degreemanagement.model.degree.Degree
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DegreeStorage @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val DEGREE_KEY = "degrees"
    }

    private val _degrees = MutableStateFlow(getDegrees())
    val degrees: StateFlow<List<Degree>> = _degrees.asStateFlow()

    fun getDegrees(): List<Degree> {
        val degreesString = sharedPreferences.getString(DEGREE_KEY, "") ?: ""
        if (degreesString.isEmpty()) return emptyList()
        return degreesString.split(";").map { Degree.fromString(it) }
    }

    fun addDegree(degree: Degree) {
        _degrees.update { currentDegrees ->
            val updatedDegrees = currentDegrees.toMutableList()
            updatedDegrees.add(degree)
            sharedPreferences.edit().putString(DEGREE_KEY, updatedDegrees.joinToString(";") { it.toString() }).apply()
            updatedDegrees
        }
    }

    fun updateDegree(originalSubject: String, newDegree: Degree) {
        val updatedList = _degrees.value.toMutableList()
        val index = updatedList.indexOfFirst { it.subject == originalSubject }
        if (index != -1) {
            updatedList[index] = newDegree
            _degrees.value = updatedList
            saveDegrees(updatedList)
        }
    }

    fun deleteDegree(subject: String) {
        val updatedList = _degrees.value.filter { it.subject != subject }
        _degrees.value = updatedList
        saveDegrees(updatedList)
    }

    private fun saveDegrees(degrees: List<Degree>) {
        val degreesString = degrees.joinToString(";") { it.toString() }
        sharedPreferences.edit().putString(DEGREE_KEY, degreesString).apply()
    }
}
