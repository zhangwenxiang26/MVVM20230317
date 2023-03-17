package com.ytyiot.ebike.mvvm

/**
 * 响应回调
 */
interface ResponseCallback<T> {
    fun onSuccess(data:T?)
    fun onFailure(e: Throwable?)
}