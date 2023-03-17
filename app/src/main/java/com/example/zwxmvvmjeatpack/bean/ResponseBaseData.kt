package com.example.zwxmvvmjeatpack.bean

class ResponseBaseData<T> {
    var msg: String? = ""
    var code: Int = -1
    var data: T? = null
}