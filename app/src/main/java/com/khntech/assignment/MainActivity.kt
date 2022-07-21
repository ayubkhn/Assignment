package com.khntech.assignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nameTxt: EditText
    private lateinit var numTxt: EditText
    private lateinit var enterBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTxt = findViewById(R.id.loginNameTxt)
        numTxt = findViewById(R.id.numberTxt)
        enterBtn = findViewById(R.id.loginBtn)

        enterBtn.setOnClickListener {
            checking()
        }
    }

    private fun checking() {
        if (nameTxt.text.isBlank() || numTxt.text.isBlank()) {
            Toast.makeText(this, "Name and Number can't be empty", Toast.LENGTH_SHORT).show()
            return
        } else {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            saveData()
        }
    }

    private fun saveData() {
        val myPrefer = getSharedPreferences("KEY", Context.MODE_PRIVATE)
        val editor = myPrefer.edit()

        editor.putString("name", nameTxt.text.toString())
        editor.putLong("num", numTxt.text.toString().toLong())
        editor.commit()
        startActivity(Intent(this, MainActivity2::class.java))
    }
}