package com.degreemanagement.view.edit_degree

import androidx.lifecycle.ViewModel
import com.degreemanagement.data.DegreeStorage
import com.degreemanagement.model.degree.Degree
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditDegreeViewModel @Inject constructor(
    private val degreeStorage: DegreeStorage
): ViewModel() {

    fun updateDegree(originalSubject: String, newSubject: String, newValue: Int) {
        val updatedDegree = Degree(newValue, newSubject)
        degreeStorage.updateDegree(originalSubject, updatedDegree)
    }

    fun deleteDegree(subject: String) {
        degreeStorage.deleteDegree(subject)
    }
}
