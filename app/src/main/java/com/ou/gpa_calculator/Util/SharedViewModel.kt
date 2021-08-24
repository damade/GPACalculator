package com.ou.gpa_calculator.Util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ou.gpa_calculator.LocalData.Model.FormDetails
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.Model.SessionInfo

class SharedViewModel: ViewModel() {

    private val mutableSemesterInfoToObserve : MutableLiveData<ArrayList<SemesterInfo>> = MutableLiveData()
    val semesterInfoToObserve : LiveData<ArrayList<SemesterInfo>> = mutableSemesterInfoToObserve

    private val mutableSessionInfoToObserve : MutableLiveData<SessionInfo> = MutableLiveData()
    val sessionInfoToObserve : LiveData<SessionInfo> = mutableSessionInfoToObserve

    private val mutableFormDetailsToObserve : MutableLiveData<FormDetails> = MutableLiveData()
    val formDetailsToObserve : LiveData<FormDetails> = mutableFormDetailsToObserve


    fun updateSemesterInfo(data: SemesterInfo) {
        var temp = mutableSemesterInfoToObserve.value
        if(temp == null){
           temp = ArrayList()
        }
        temp.add(data)
        temp.let {
            mutableSemesterInfoToObserve.value = it
        }
    }


    fun updateSessionInfo(data: SessionInfo){
        mutableSessionInfoToObserve.value = data
    }

    fun updateFormDetails(data: FormDetails){
        mutableFormDetailsToObserve.value = data
    }

    fun clearSemesterInfo() {
        mutableSemesterInfoToObserve.value = null
    }

    fun clearSessionInfo() {
        mutableSessionInfoToObserve.value = null
    }

    fun clearFormDetails() {
        mutableFormDetailsToObserve.value = null
    }

}


