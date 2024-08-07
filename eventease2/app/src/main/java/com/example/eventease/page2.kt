package com.example.eventease

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class page2:AppCompatActivity() {
    private lateinit var photo: ImageButton
    private lateinit var cater: ImageButton
    private lateinit var decor: ImageButton
    private lateinit var makeup: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page2)

        val intent = intent
        val usr_name = intent.getStringExtra("usr_name")

        photo=findViewById(R.id.photobut)
        cater=findViewById(R.id.caterbut)
        decor=findViewById(R.id.decorbut)
        makeup=findViewById(R.id.makeupbut)
        photo.setOnClickListener()
        {
            val intent = Intent(this, photoselected::class.java)
            intent.putExtra("usr_name",usr_name)
            startActivity(intent)
        }
        cater.setOnClickListener()
        {
            val intent = Intent(this, caterselected::class.java)
            intent.putExtra("usr_name",usr_name)
            startActivity(intent)
        }
        decor.setOnClickListener()
        {

            val intent = Intent(this, decorselected::class.java)
            intent.putExtra("usr_name",usr_name)
            startActivity(intent)
        }
        makeup.setOnClickListener()
        {
            val intent = Intent(this, makeupselected::class.java)
            intent.putExtra("usr_name",usr_name)
            startActivity(intent)
        }
    }
}