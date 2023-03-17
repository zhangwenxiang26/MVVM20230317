package com.ytyiot.ebike.mvvm.login

import com.example.zwxmvvmjeatpack.bean.LoginBean
import com.example.zwxmvvmjeatpack.bean.ResponseBaseData
import com.kunminx.architecture.domain.message.MutableResult
import com.ytyiot.ebike.mvvm.DataRepository
import com.ytyiot.ebike.mvvm.ResponseCallback
import com.ytyiot.ebike.mvvm.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    //接收登录成功数据
    val loginSuccessData = MutableResult<LoginBean>()

    //接收登录失败数据
    val loginFailData = MutableResult<String>()


    fun login(token: String) {

        DataRepository.login(token, object :
            ResponseCallback<ResponseBaseData<LoginBean?>?> {
            override fun onSuccess(responseData: ResponseBaseData<LoginBean?>?) {
                //登录成功
                responseData?.apply {
                    loginSuccessData.value = data
                }
            }

            override fun onFailure(e: Throwable?) {
                //登录失败
                e?.apply {
                    loginFailData.value = message
                }
            }

        })
    }
}