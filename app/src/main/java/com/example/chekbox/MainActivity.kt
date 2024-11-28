package com.example.chekbox

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chekbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {
                v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                systemBars.bottom)
            insets
        }
        val btn : Button = findViewById(R.id.btnChoose)
        val tvChos : TextView = findViewById(R.id.tvChoose)
        val img : ImageView = findViewById(R.id.kartinka)
        btn.setOnClickListener {
            if (binding.cbCar.isChecked){
                tvChos.text = binding.cbCar.text
                img.visibility = android.view.View.VISIBLE
                img.setImageResource(R.drawable.car)
            }else if (binding.cbBus.isChecked){
                tvChos.text = binding.cbBus.text
                img.visibility = android.view.View.VISIBLE
                img.setImageResource(R.drawable.bus)
            }else if (binding.cbkolyaska.isChecked){
                tvChos.text = binding.cbkolyaska.text
                img.visibility = android.view.View.VISIBLE
                img.setImageResource(R.drawable.kolyaska)
            }else {
                tvChos.text = "Ничего не выбранно"
                img.visibility = android.view.View.VISIBLE
                img.setImageResource(R.drawable.grusnich)
            }
        }
    }
}