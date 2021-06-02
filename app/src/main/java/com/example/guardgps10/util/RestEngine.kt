package com.example.guardgps10.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestEngine {

    companion object{
        fun getRestEngine(): Retrofit{
            val gson: Gson = GsonBuilder().setLenient().create()
            val interceptor= HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor ).build()
             val retrofit = Retrofit.Builder()
                 .baseUrl("https://guardgps-7abb7-default-rtdb.firebaseio.com/")
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .client(client)
                 .build()
            return retrofit
        }
    }
}