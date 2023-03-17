package com.ytyiot.ebike.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

abstract class MvvmVbActivity <VM : BaseViewModel,VB : ViewBinding> : FragmentActivity() {
    lateinit var vBinding: VB
    lateinit var vModel: VM

    /**
     * 获取布局资源文件
     */
    protected abstract fun initViewBinding(inflater: LayoutInflater): VB

    /**
     * 设置监听
     */
    protected abstract fun initListener()

    /**
     * 沉浸式
     */
    protected abstract fun initImmersion()

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel(): VM

    /**
     * 绑定数据
     */
    protected abstract fun loadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = initViewBinding(layoutInflater)
        setContentView(vBinding.root)
        initListener()
        initImmersion()
        vModel = initViewModel()
        loadData()
    }


    override fun onDestroy() {
        super.onDestroy()
        hidePb()
    }


    open fun showToast(msg: String?) {}


    open fun showPb(msg: String?) {}


    open fun hidePb() {}
}