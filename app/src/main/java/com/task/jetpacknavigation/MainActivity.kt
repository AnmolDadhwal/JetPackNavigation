package com.task.jetpacknavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.task.jetpacknavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    var navController:NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController=findNavController(R.id.navController)
        navController?.addOnDestinationChangedListener{_,destination,_->
            when(destination.id){
                R.id.jetPackNavigation->supportActionBar?.title="Enter Email"
                R.id.secondFragment->supportActionBar?.title="Enter OTP"
                R.id.thirdFragment->supportActionBar?.title="Set New Password"
            }
        }
    }
}