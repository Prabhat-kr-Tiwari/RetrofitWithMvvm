package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.model.Jokes
import com.example.retrofitmvvm.repository.MemesRepository
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepository: MemesRepository) :ViewModel(){

    init {
        viewModelScope.launch {
            memesRepository.getMemes()
        }


    }
    val memes:LiveData<Jokes>
        get()=memesRepository.memes



}