package com.mmnaguib.organizationalhierarchy.network

import android.media.MediaFormat.KEY_LANGUAGE
import com.mmnaguib.organizationalhierarchy.utils.TOKEN
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NetworkInterceptor : Interceptor, KoinComponent {

    companion object{
        val STEP_ONE_DONE = "1"
        val STEP_TWO_DONE = "2"
        val STEP_THREE_DONE = "3"
        val STEP_FOUR_DONE = "4"
    }


    override fun intercept(chain: Interceptor.Chain): Response {

        val request: Request = chain.request()
        val newRequest: Request

        //TODO chane later
        newRequest = request.newBuilder()
            .header("Content-Type", "application/json")
            .header(
                "Authorization",
                 TOKEN?: ""
            )
            .build()
        return chain.proceed(newRequest)
    }


}