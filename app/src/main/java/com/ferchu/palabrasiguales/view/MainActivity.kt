package com.ferchu.palabrasiguales.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ferchu.palabrasiguales.R
import com.ferchu.palabrasiguales.databinding.ActivityMainBinding
import com.ferchu.palabrasiguales.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controladores()
        observadorViewModel()
    }

    private fun controladores() {
        binding.btnCompare.setOnClickListener {
            val firstText = binding.etFirstText.text.toString()
            val secondText = binding.etSecondText.text.toString()
            mainViewModel.compare(firstText, secondText)
        }
    }

    private fun observadorViewModel() {
        mainViewModel.isEqual.observe(this) { isEqual ->
            if (isEqual) {
                binding.tvResult.text = "Los textos son iguales."
            }
            else {
                binding.tvResult.text = "Los textos no son iguales."
            }
        }
    }
}