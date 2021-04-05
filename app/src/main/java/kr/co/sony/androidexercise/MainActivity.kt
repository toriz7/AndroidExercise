package kr.co.sony.androidexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.sony.androidexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.textView.text="Hello Software World!"
        binding.toggleButton.textOff = "퇴직"
        binding.toggleButton.textOn ="입사"
        binding.toggleButton.isChecked=true
    }
}