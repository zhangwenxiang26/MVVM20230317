package com.example.zwxmvvmjeatpack.api

import com.example.zwxmvvmjeatpack.bean.LoginBean
import com.example.zwxmvvmjeatpack.bean.ResponseBaseData
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun goLogin(@Body requestBody: RequestBody?): Observable<ResponseBaseData<LoginBean?>?>
}