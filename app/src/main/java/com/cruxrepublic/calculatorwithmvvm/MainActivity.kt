package com.cruxrepublic.calculatorwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cruxrepublic.calculatorwithmvvm.databinding.ActivityMainBinding
import com.cruxrepublic.calculatorwithmvvm.ui.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel =ViewModelProviders.of(this).get(MainViewModel::class.java)

    }
}
