package com.oxygenvideo.data.interfaces

import retrofit2.http.Body
import retrofit2.http.POST

interface ExampleService {
    @POST("com.oxygenvideo/data/create")
    fun createData(@Body data: Data)
}
//Retrofit会自动解析Data中的数据为JSON
data class Data (var id: Int = 2)
