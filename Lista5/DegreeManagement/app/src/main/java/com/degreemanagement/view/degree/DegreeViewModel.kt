package com.degreemanagement.view.degree

import androidx.lifecycle.ViewModel
import com.degreemanagement.data.DegreeStorage
import com.degreemanagement.model.degree.Degree
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DegreeViewModel @Inject constructor(
    private val degreeStorage: DegreeStorage
): ViewModel() {

    fun getDegreeState(): StateFlow<List<Degree>> {
        return degreeStorage.degrees
    }


}