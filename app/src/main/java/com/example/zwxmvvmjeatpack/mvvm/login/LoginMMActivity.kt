package com.ytyiot.ebike.mvvm.login

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.zwxmvvmjeatpack.databinding.ActivityLoginMmactivityBinding
import com.ytyiot.ebike.mvvm.base.MvvmVbActivity

class LoginMMActivity : MvvmVbActivity<LoginViewModel, ActivityLoginMmactivityBinding>() {
    override fun initViewBinding(inflater: LayoutInflater): ActivityLoginMmactivityBinding {
        return ActivityLoginMmactivityBinding.inflate(inflater)
    }

    override fun initListener() {
        vBinding.btnLogin.setOnClickListener {
            vModel.login("token")
        }

        vModel.loginSuccessData.observe(this){
            //登录成功 Todo
        }

        vModel.loginFailData.observe(this){
            //登录失败 Todo
        }
    }

    override fun initImmersion() {

    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProvider(
            viewModelStore,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
            .get(LoginViewModel::class.java)
    }

    override fun loadData() {

    }

}