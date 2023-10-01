package com.piyushkumar.temperature_calculator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CelsiusToFahrenheit : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var celsiusInput: EditText
    private lateinit var convertButton: Button
    private lateinit var fahrenheitResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_celsius_to_fahrenheit, container, false)

        celsiusInput = view.findViewById(R.id.input_temp)
        convertButton = view.findViewById(R.id.convert_button)
        fahrenheitResult = view.findViewById(R.id.output_temp)

        convertButton.setOnClickListener {
            // Convert the Celsius value entered in the input field
            val celsiusValue = celsiusInput.text.toString().toDoubleOrNull() ?: 0.0
            val fahrenheitValue = convertCelsiusToFahrenheit(celsiusValue)

            // Display the result in the TextView
            fahrenheitResult.text = "Result in Fahrenheit: $fahrenheitValue °F"
        }

        return view
    }

    // Function to convert Celsius to Fahrenheit
    private fun convertCelsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CelsiusToFahrenheit().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
