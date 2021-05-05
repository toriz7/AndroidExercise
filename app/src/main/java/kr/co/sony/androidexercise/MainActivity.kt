package kr.co.sony.androidexercise

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Switch
import kr.co.sony.androidexercise.databinding.ActivityMainBinding
/*
binding 시 주의
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_main)
        setContentView(view)
        binding.button.setOnClickListener{
            when(binding.radioGroup1.checkedRadioButtonId){
                R.id.radioButton ->{
                    binding.textView.text="radio1 체크"
                }
                R.id.radioButton2 ->{
                    binding.textView.text="radio2 체크"
                }
                R.id.radioButton3 ->{
                    binding.textView.text="radio3 체크"
                }
            }
        }
        binding.button2.setOnClickListener{
            if(binding.switch1.isChecked){
                binding.textView.text="switch1 check"
            }
            else{
                binding.textView.text="switch1 not check"
            }
        }
        binding.radioGroup1.setOnCheckedChangeListener(listener_radio)
        binding.switch1.setOnCheckedChangeListener(listenr_switch)
        binding.switch2.setOnCheckedChangeListener(listenr_switch)
        /* check box button
        binding.button.setOnClickListener{
            binding.textView.text=""
            if(binding.checkBox.isChecked == true){
                binding.textView.append("first box checked\n")
            } else{
                binding.textView.append("first box not  checked\n")
            }

            if(binding.checkBox2.isChecked == true){
                binding.textView.append("second box checked\n")
            } else{
                binding.textView.append("second box not  checked\n")
            }

            if(binding.checkBox3.isChecked == true){
                binding.textView.append("third box checked\n")
            } else{
                binding.textView.append("third box not  checked\n")
            }
        }
        */
        /*  toggle buttons
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
         */
        /* checkbox
        binding.button2.setOnClickListener{
            binding.checkBox.toggle()
            binding.checkBox2.toggle()
            binding.checkBox3.toggle()
        }
        binding.checkBox.setOnCheckedChangeListener(listener)
        binding.checkBox2.setOnCheckedChangeListener(listener)
        binding.checkBox3.setOnCheckedChangeListener{buttonView,isChecked -> //고차함수 버전
            if(isChecked ==true){
                binding.textView.text="third box checked"
            }
            else{
                binding.textView.text="third box not checked"
            }
        }
    }

         */
        /* checkbox
    var listener = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.checkBox ->{
                    if(isChecked ==true){
                        binding.textView.text="first box checked"
                    }
                    else{
                        binding.textView.text="first box not checked"
                    }
                }
                R.id.checkBox2 ->{
                    if(isChecked ==true){
                        binding.textView.text="second box checked"
                    }
                    else{
                        binding.textView.text="second box not checked"
                    }
                }
                R.id.checkBox2 ->{
                    if(isChecked ==true){
                        binding.textView.text="third box checked"
                    }
                    else{
                        binding.textView.text="third box not checked"
                    }
                }
            }
        }

     */
        /* text
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
*/
    }
    var listenr_switch=object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(switchId: CompoundButton?, check: Boolean) {
            when(switchId){
                binding.switch1->{
                    binding.textView.text="switch 1 check"
                }
                binding.switch2->{
                    binding.textView.text="switch 2 check"
                }
            }
        }
    }
    var listener_radio=object :RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkId: Int) {
            when(group?.id){
                R.id.radioGroup1 ->{
                    when(checkId){
                        R.id.radioButton -> {
                            binding.textView.text="radio1 이 체크"
                        }
                        R.id.radioButton2 -> {
                            binding.textView.text="radio2 이 체크"
                        }
                        R.id.radioButton3 -> {
                            binding.textView.text="radio3 이 체크"
                        }
                    }
                }
            }
        }
    }
}