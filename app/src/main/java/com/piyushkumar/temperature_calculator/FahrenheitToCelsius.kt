package com.piyushkumar.temperature_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FahrenheitToCelsius : Fragment() {

    private lateinit var fahrenheitInput: EditText
    private lateinit var convertButton: Button
    private lateinit var celsiusResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fahrenheit_to_celsius, container, false)

        fahrenheitInput = view.findViewById(R.id.input_temp)
        convertButton = view.findViewById(R.id.convert_button)
        celsiusResult = view.findViewById(R.id.output_temp)

        convertButton.setOnClickListener {
            // Convert the Fahrenheit value entered in the input field
            val fahrenheitValue = fahrenheitInput.text.toString().toDoubleOrNull() ?: 0.0
            val celsiusValue = convertFahrenheitToCelsius(fahrenheitValue)

            // Display the result in the TextView
            celsiusResult.text = "Result in Celsius: $celsiusValue °C"
        }

        return view
    }

    // Function to convert Fahrenheit to Celsius
    private fun convertFahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    companion object {
        @JvmStatic
        fun newInstance(s: String, s1: String) = FahrenheitToCelsius()
    }
}
