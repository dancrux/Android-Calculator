package com.cruxrepublic.calculatorwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
//        val viewModel =ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

         val navController = this.findNavController(R.id.nav_host_fragment)

    navController.addOnDestinationChangedListener{controller, destination, arguments ->
        title = when (destination.id){
            R.id.calculatorFragment -> "Calculator"
            else -> "History"
        }

    }
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()


    }


}
