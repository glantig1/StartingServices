package com.example.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
lateinit var x: MyService
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val someEdit = findViewById<EditText>(R.id.editTextText)
        findViewById<Button>(R.id.button).setOnClickListener{
            x = MyService()
            startService(Intent(this,x::class.java),)
            x.enter = someEdit.text.toString().toInt()
        }
    }
}