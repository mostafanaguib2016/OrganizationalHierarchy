package com.mmnaguib.organizationalhierarchy.network

import com.mmnaguib.organizationalhierarchy.model.EmployeesResponse
import com.mmnaguib.organizationalhierarchy.utils.GET_USERS
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService
{

    @POST(GET_USERS)
    suspend fun getCompanyUsers
                (@Header("Authorization") token: String): EmployeesResponse

}