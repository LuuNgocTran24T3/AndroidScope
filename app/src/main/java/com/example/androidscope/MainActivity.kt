package com.example.androidscope

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidscope.databinding.ActivityMainBinding

data class SinhVien(
    var hoTen: String = "",
    var tuoi: Int = 0
)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {

            val sinhVien = SinhVien().apply {
                hoTen = binding.edtName.text.toString()
                tuoi = binding.edtAge.text.toString().toIntOrNull() ?: 0
            }

            val ketQua = sinhVien.let {
                "Họ tên: ${it.hoTen}\nTuổi: ${it.tuoi}"
            }

            binding.tvResult.text = ketQua
        }
    }
}