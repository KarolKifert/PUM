package com.degreemanagement.view.add_degree

import androidx.lifecycle.ViewModel
import com.degreemanagement.data.DegreeStorage
import com.degreemanagement.model.degree.Degree
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddDegreeViewModel @Inject constructor(
    private val degreeStorage: DegreeStorage
): ViewModel() {

    fun addDegree(subject: String, value: Int) {
        val newDegree = Degree(value, subject)
        degreeStorage.addDegree(newDegree)
    }
}
