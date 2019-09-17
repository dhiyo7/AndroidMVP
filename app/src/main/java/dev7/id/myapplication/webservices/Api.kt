package dev7.id.myapplication.webservices

import dev7.id.myapplication.models.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

class ApiClient{
    companion object {
        private const val ENPOINT = "https://jsonplaceholder.typicode.com/"
        private var retrofit : Retrofit? = null
        private var client = OkHttpClient.Builder().apply {
            writeTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
        }.build()

        private fun getClient() : Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder().apply {
                    baseUrl(ENPOINT)
                    client(client)
                    addConverterFactory(GsonConverterFactory.create())
                }.build()
                return retrofit!!
            }else{
                return retrofit!!
            }
        }
        fun instance_api() : ApiService = getClient().create(ApiService::class.java)
    }
}

interface ApiService{
    @GET("users")
    fun allUsers() : Call<List<User>>
}