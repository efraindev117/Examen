package com.example.examen.network

import com.example.examen.model.data.GitResponseUserItem
import com.example.examen.utils.Constants.PATH_USER
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GitService {
    @GET(PATH_USER)
    @Headers("Authorization: token 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")
    suspend fun getResponseUser(): Response<ArrayList<GitResponseUserItem>>
}