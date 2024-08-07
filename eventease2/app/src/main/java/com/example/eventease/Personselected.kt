package com.example.eventease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast

class Personselected: AppCompatActivity() {
    private lateinit var appoint:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personselt)

        val db = DBConnection(this, "orderdetails",1)

        val intent = intent

        val usr_name = intent.getStringExtra("usr_name") //name
        val booking = intent.getStringExtra("booking")   //booking
        val name = intent.getStringExtra("name")   //person
        val venue = intent.getStringExtra("venue")
        val email = intent.getStringExtra("email")
        val pnos = intent.getStringExtra("pnos") //phone
        val rate = intent.getStringExtra("rate")
        val price=intent.getStringExtra("b_price")
        val img = intent.getIntExtra("imgpic",0)


        val tvName: TextView = findViewById(R.id.p_name)
        val tvVenue: TextView = findViewById(R.id.p_venue)
        val tvEmail: TextView = findViewById(R.id.p_mail)
        val tvPnos: TextView = findViewById(R.id.p_phone)
        val tvRate: TextView = findViewById(R.id.p_rate)
        val tvpic: ImageView = findViewById(R.id.p_pic)
        val tvprice: TextView = findViewById(R.id.p_price)
        appoint = findViewById(R.id.appoint)

        tvName.text = name
        tvVenue.text = venue
        tvEmail.text = email
        tvPnos.text = pnos
        tvRate.text = rate
        tvprice.text = price
        tvpic.setImageResource(img)

        appoint.setOnClickListener()
        {
            val usrn=usr_name.toString()
            val result= db.insert_orders(usr_name.toString(), booking.toString(), name.toString(), pnos.toString())
            if(result.equals(-1))
            {
                Toast.makeText(this, usrn + " NOT added", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, usrn + " added to database", Toast.LENGTH_LONG).show()

            }

            val i= Intent(this,confirmed_sms::class.java)
            i.putExtra("pnos",pnos)
            startActivity(i)
        }

    }
}