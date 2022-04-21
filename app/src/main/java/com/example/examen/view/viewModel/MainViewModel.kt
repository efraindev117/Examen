package com.example.examen.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.model.data.GitResponseUserItem
import com.example.examen.model.interactor.MainInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val interactor: MainInteractor) : ViewModel() {

    private val userGitResponse: MutableLiveData<ArrayList<GitResponseUserItem>> by lazy {
        MutableLiveData<ArrayList<GitResponseUserItem>>().also { loadDataGit() }
    }

    fun getDataCallBackGitResponse(): LiveData<ArrayList<GitResponseUserItem>> = userGitResponse

    private fun loadDataGit() = viewModelScope.launch{
        interactor.getDataGit { userGitResponse.value = it  }
    }

}