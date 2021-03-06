package com.example.examen.model.interactor

import com.example.examen.model.data.GitResponseUserItem
import com.example.examen.repository.GitRepository
import javax.inject.Inject

class MainInteractor  @Inject constructor(private val repo: GitRepository){
    private val list = java.util.ArrayList<GitResponseUserItem>()

    suspend fun getDataGit(callback: (ArrayList<GitResponseUserItem>)-> Unit){
        repo.getDataResponse().let { responseGit ->
            if (responseGit.isSuccessful){
                val listResponse: ArrayList<GitResponseUserItem>? = responseGit.body()
                listResponse.let {
                    if (it != null) {
                        list.addAll(it)
                        callback(it)
                    }
                }
            }
        }
    }
}
