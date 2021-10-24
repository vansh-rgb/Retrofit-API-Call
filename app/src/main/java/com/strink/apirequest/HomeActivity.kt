package com.strink.apirequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.strink.apirequest.databinding.ActivityMainBinding
import com.strink.apirequest.fragments.HomeFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,HomeFragment())
            .commit()
    }
}