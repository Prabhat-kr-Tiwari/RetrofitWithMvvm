package com.example.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.model.Jokes

class MemesRepository(private val apiInterface: ApiInterface) {

    private val memesLiveData=MutableLiveData<Jokes>()

        //this is to be exposed
    val memes:LiveData<Jokes>
        get ()=memesLiveData
    suspend fun getMemes(){
        val result= apiInterface.getMemes()
        if (result.body()!=null){
            memesLiveData.postValue(result.body())
        }
    }

}