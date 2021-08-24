package com.example.valorant.di

import com.example.valorant.data.api.APIInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 싱글톤
object RetrofitBuilder {
    val httpClient:OkHttpClient = OkHttpClient()
    // Retrofit을 사용하기 위한 함수
    // Base_url에 서버의 url를 넣으면 사용 가능하다
    val gson : Gson =  GsonBuilder().setLenient().create()


    private val retrofitClient: Retrofit.Builder by lazy{
        Retrofit.Builder()
    }
    // API서버와 연결 시 Retrofit객체를 구현할 인터페이스를 통해 만든다.
    val CONNET_SERVICE: APIInterface by lazy{
        retrofitClient
                .baseUrl("http://192.168.25.41:5000/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIInterface::class.java)
    }
    val connect_henrikdev: APIInterface by lazy {
        retrofitClient
                .baseUrl("https://api.henrikdev.xyz/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIInterface::class.java)
    }
    val connect_riot by lazy{
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "bearer token") //"Bearer $token"
                    .build()
            chain.proceed(newRequest)
        }).build()

        retrofitClient
                .client(client)
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}