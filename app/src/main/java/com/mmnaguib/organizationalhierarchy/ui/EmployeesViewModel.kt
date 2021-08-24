package com.mmnaguib.organizationalhierarchy.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mmnaguib.organizationalhierarchy.model.EmployeesResponse
import com.mmnaguib.organizationalhierarchy.network.ApiService
import com.mmnaguib.organizationalhierarchy.utils.TOKEN
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeesViewModel(val apiService: ApiService): ViewModel()
{

    private val _employeesData = MutableLiveData<EmployeesResponse>()
    val employeesData: LiveData<EmployeesResponse> = _employeesData

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> = _loading

    private val TAG = EmployeesResponse::class.java.simpleName


    init {
        getCompanyUsers()
    }

    fun getCompanyUsers()
    {

        CoroutineScope(Dispatchers.IO).launch {

            kotlin.runCatching {

                apiService.getCompanyUsers(TOKEN)

            }.onSuccess {

                _loading.postValue(false)
                _employeesData.postValue(it)

            }.onFailure {

                Log.e(TAG, "ErrorMsg: ${it.message}  ${it.cause.toString()}" )

            }


        }

    }


}