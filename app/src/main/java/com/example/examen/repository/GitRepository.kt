package com.example.examen.repository

import com.example.examen.network.GitService
import javax.inject.Inject

class GitRepository @Inject constructor(private val gitService: GitService) {

    suspend fun getDataResponse() = gitService.getResponseUser()
}