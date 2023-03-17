package com.ytyiot.ebike.mvvm.base

import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

open class BaseRepository {
    fun getPostRequestBody(data:String,contentType: MediaType) : RequestBody{
        return data.toRequestBody(contentType)
    }
}