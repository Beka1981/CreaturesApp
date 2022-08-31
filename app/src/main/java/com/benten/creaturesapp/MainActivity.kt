package com.benten.creaturesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benten.creaturesapp.databinding.ActivityMainBinding
import com.benten.creaturesapp.views.allCreatures.AllCreaturesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportFragmentManager.findFragmentById(R.id.flContent) == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, AllCreaturesFragment())
                addToBackStack(AllCreaturesFragment::class.java.name)
                commit()
            }
        }


    }
}