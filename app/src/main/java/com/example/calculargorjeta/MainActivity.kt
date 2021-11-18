package com.example.calculargorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculargorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {
        val stringInTextField = binding.Consumo.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.Espetacular -> 0.20
            R.id.Bom -> 0.18
            else -> 0.15

        }
        var tip = tipPercentage * cost!!
        binding.Arredondar.isChecked
        if (binding.Arredondar.isChecked) {
            tip = kotlin.math.ceil(tip)

        }
        if (cost == null) {
            binding.Resultado.text = ""
            return
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.Resultado.text = getString(R.string.tip_amount, formattedTip)

    }

}