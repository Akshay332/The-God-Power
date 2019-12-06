package com.goddess.base.repository.networkrequest

import com.goddess.base.R
import com.goddess.base.repository.models.Error
import com.goddess.base.repository.models.PojoBackendResponse
import com.goddess.base.repository.models.PojoNetworkResponse
import okhttp3.ResponseBody
import java.io.IOException

/**
 * Created by ShrayChona on 03-10-2018.
 */
object RetrofitRequest {

    fun checkForNetworkResponseCode(code: Int): PojoNetworkResponse {
        return when (code) {
            200 -> PojoNetworkResponse(true, false)
            403, 401 -> PojoNetworkResponse(false, true)
            else -> PojoNetworkResponse(false, false)
        }
    }

    fun checkForBackendResponseCode(code: Int): PojoBackendResponse {
        return when (code) {
            100 -> PojoBackendResponse(true, false, false)
            401 -> PojoBackendResponse(false, true, false)
            else -> PojoBackendResponse(false, false, true)
        }
    }

    fun getErrorMessage(responseBody: ResponseBody): String {
        val errorMessage = ""
        try {
            val errorConverter = RestClient.retrofitInstance!!
                    .responseBodyConverter<Error>(Error::class.java, arrayOfNulls<Annotation>(0))
            return errorConverter.convert(responseBody)!!.message
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return errorMessage
    }

    fun getRetrofitError(t: Throwable): Int {
        return if (t is IOException) {
            R.string.no_internet
        } else {
            R.string.retrofit_failure
        }
    }

}