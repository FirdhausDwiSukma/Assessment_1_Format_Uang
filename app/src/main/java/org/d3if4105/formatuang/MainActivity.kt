package org.d3if4105.formatuang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if4105.formatuang.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener { ubahRupiah() }
        binding.btnReset.setOnClickListener { reset() }
    }

    private fun ubahRupiah(){
        val inputan = binding.inputNumInp.text.toString()
        if (TextUtils.isEmpty(inputan)){
            Toast.makeText(this, R.string.masukkan_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val formatter = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        val hasilFormat = formatter.format(binding.inputNumInp.text.toString().toDouble())
        binding.output.text = hasilFormat
    }

    private fun reset(){
        binding.inputNumInp.requestFocus()
        binding.inputNumInp.setText("")
        binding.output.text= ""
    }
}