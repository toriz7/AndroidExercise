package kr.co.sony.androidexercise

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kr.co.sony.androidexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.textView1.text="Hello Software World!"
        binding.toggleButton.textOff = "퇴직"
        binding.toggleButton.textOn ="입사zz"
        binding.toggleButton.isChecked=true

        binding.button1.setOnClickListener{
            binding.textView1.text=binding.EditText.text
            
            val imm=getSystemService(Context.INPUT_METHOD_SERVICE)  as InputMethodManager //android 기능들을 가져다 쓰고 싶을 때
            imm.hideSoftInputFromWindow(binding.EditText.windowToken,0)

            binding.EditText.clearFocus()

        }
        binding.EditText.setOnEditorActionListener { textView, i, keyEvent ->
            binding.textView1.text="Entered"
            binding.textView2.text=binding.EditText.text
            false //엔터 후 내려갈 것인가 말 것인가
        }
        binding.EditText.addTextChangedListener(listener1)

    }
    
    val listener1= object : TextWatcher{ //이름기억
        //문자열이 변경되기 전
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.textView1.text="before : $p0"
        }
        //문자열이 변경 작업이 완료되었을 때
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.textView2.text="changed : $p0"
        }
        //변경 된 문자열이 화면에 반영되었을 때
        override fun afterTextChanged(p0: Editable?) {
            binding.textView3.text="after : $p0"
        }

    }

}