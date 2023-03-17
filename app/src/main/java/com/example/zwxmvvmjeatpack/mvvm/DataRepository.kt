package com.ytyiot.ebike.mvvm

import android.util.Log
import com.example.zwxmvvmjeatpack.bean.LoginBean
import com.example.zwxmvvmjeatpack.bean.ResponseBaseData
import com.example.zwxmvvmjeatpack.net.BaseObserver
import com.example.zwxmvvmjeatpack.net.RetrofitManager
import com.example.zwxmvvmjeatpack.net.RxScheduler
import com.ytyiot.ebike.mvvm.base.BaseRepository
import okhttp3.MediaType.Companion.toMediaType
import org.json.JSONException
import org.json.JSONObject

object DataRepository : BaseRepository() {

    fun login(
        token: String,
        callback: ResponseCallback<ResponseBaseData<LoginBean?>?>?
    ) {
        try {
            val postBody = JSONObject()
            postBody.put("token", token)
            val requestBody = getPostRequestBody(postBody.toString(),"application/json".toMediaType())
            RetrofitManager.getInstance().createEBikeApi()
                .goLogin(requestBody)
                .compose<ResponseBaseData<LoginBean?>>(RxScheduler.Obs_io_main())
                .subscribe(object : BaseObserver<ResponseBaseData<LoginBean?>>(){
                    override fun onSuccess(t: ResponseBaseData<LoginBean?>) {
                        callback?.onSuccess(t)
                    }

                    override fun failure(e: Throwable?) {
                        callback?.onFailure(e)
                    }
                })
        } catch (e: JSONException) {
            Log.e("log", e.message, e)
        }
    }
}