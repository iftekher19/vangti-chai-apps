package com.example.vangtichai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vangtichai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var amount = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { addDigit("0") }
        binding.btn1.setOnClickListener { addDigit("1") }
        binding.btn2.setOnClickListener { addDigit("2") }
        binding.btn3.setOnClickListener { addDigit("3") }
        binding.btn4.setOnClickListener { addDigit("4") }
        binding.btn5.setOnClickListener { addDigit("5") }
        binding.btn6.setOnClickListener { addDigit("6") }
        binding.btn7.setOnClickListener { addDigit("7") }
        binding.btn8.setOnClickListener { addDigit("8") }
        binding.btn9.setOnClickListener { addDigit("9") }

        binding.btnClear.setOnClickListener {
            amount = ""
            updateDisplay()
        }

        updateDisplay()
    }

    private fun addDigit(digit: String) {
        amount += digit
        updateDisplay()
    }

    private fun updateDisplay() {

        val value = if (amount.isEmpty()) 0 else amount.toInt()

        binding.txtAmount.text = value.toString()

        calculateChange(value)
    }

    private fun calculateChange(value: Int) {

        var remaining = value

        binding.t500.text = "500      ${remaining / 500}"
        remaining %= 500

        binding.t100.text = "100      ${remaining / 100}"
        remaining %= 100

        binding.t50.text = "50        ${remaining / 50}"
        remaining %= 50

        binding.t20.text = "20        ${remaining / 20}"
        remaining %= 20

        binding.t10.text = "10        ${remaining / 10}"
        remaining %= 10

        binding.t5.text = "5          ${remaining / 5}"
        remaining %= 5

        binding.t2.text = "2          ${remaining / 2}"
        remaining %= 2

        binding.t1.text = "1          ${remaining}"
    }
}