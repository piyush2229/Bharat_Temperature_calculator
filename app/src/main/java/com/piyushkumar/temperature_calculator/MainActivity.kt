package com.piyushkumar.temperature_calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the fragment manager
        fragmentManager = supportFragmentManager

        val button1 = findViewById<Button>(R.id.celsius_to_fahrenheit_button)
        val button2 = findViewById<Button>(R.id.fahrenheit_to_celsius_button)

        button1.setOnClickListener {
            // Replace the current fragment with the Celsius to Fahrenheit fragment
            replaceFragment(CelsiusToFahrenheit.newInstance("", ""))
        }

        button2.setOnClickListener {
            // Replace the current fragment with the Fahrenheit to Celsius fragment
            replaceFragment(FahrenheitToCelsius.newInstance("", ""))
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null) // This allows you to navigate back to the previous fragment
        transaction.commit()
    }
}
