package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.api.ApiInterface
import com.example.retrofitmvvm.api.RetrofitHelper
import com.example.retrofitmvvm.repository.MemesRepository
import com.example.retrofitmvvm.repository.MemesViewModelFactory
import com.example.retrofitmvvm.viewmodel.MemesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var memesViewModel: MemesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface=RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val memesRepository=MemesRepository(apiInterface)
        memesViewModel=ViewModelProvider(this,MemesViewModelFactory(memesRepository)).get(MemesViewModel::class.java)
        memesViewModel.memes.observe( this,{

            Log.d("PRABHAT", "onCreate: ${it.toString()}")
            
        }

        )
    }
}