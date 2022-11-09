package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var edtWidht: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidht = findViewById(R.id.edt_width)
        edtWidht = findViewById(R.id.edt_height)
        edtWidht = findViewById(R.id.edt_lenght)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }
    override fun onClick(view: View?){
        if(view?.id == R.id.btn_calculate){
            val inputlenght= edtLength.text.toString().trim()
            val inputWidth= edtLength.text.toString().trim()
            val inputHeight= edtLength.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (TextUtils.isEmpty(inputlenght)){
                isEmptyFields = true
                edtLength.error="Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true
                edtWidht.error="Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true
                edtHeight.error="Field ini tidak boleh kosong"
            }

            val length = convertToDouble(inputlenght)
            val width = convertToDouble(inputWidth)
            val height = convertToDouble(inputHeight)

            if (length == null){
                isInvalidDouble = true
                edtLength.error = "nilai tidak valid"
            }
            if (width == null){
                isInvalidDouble = true
                edtWidht.error = "nilai tidak valid"
            }

            if (height == null){
                isInvalidDouble = true
                edtHeight.error = "nilai tidak valid"
            }

            if(!isEmptyFields && !isInvalidDouble){
                val volume = height!!.toDouble() * length!!.toDouble() * length.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    private fun convertToDouble(str: String):Double?{
        return try {
            str.toDouble()
        }catch (e : NumberFormatException){
            null
        }
    }

    companion object{
        private const val STATE_RESULT = "state_result"

        }
    }


