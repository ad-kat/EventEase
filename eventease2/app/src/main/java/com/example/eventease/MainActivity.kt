package com.example.eventease

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var event: Spinner
    private lateinit var dates: DatePicker
    private lateinit var showbtn:Button
    private lateinit var enterbtn :Button
    private lateinit var eventbtn:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.name)
        showbtn=findViewById(R.id.showbtn)
        enterbtn=findViewById(R.id.enterbtn)
        eventbtn=findViewById(R.id.enterevent)
        event=findViewById(R.id.spinner)
        dates=findViewById(R.id.date)
        val eventype = resources.getStringArray(R.array.events)
        val adap = ArrayAdapter(this, android.R.layout.simple_spinner_item, eventype)
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        event.adapter = adap



        enterbtn.setOnClickListener(){
            val n=findViewById<EditText>(R.id.name).text.toString()
            val ev=event.selectedItem.toString()
            val date="${dates.month}/${dates.dayOfMonth}/${dates.year}"
            val str="NAME:$n EVENT:$ev DATE:$date"
            val db=DBConnection(this,"userdetails",1)


            val result= db.insert(n, ev, date)
            if(result.equals(-1))
            {
                Toast.makeText(this, n + " NOT added", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, n + " added to database", Toast.LENGTH_LONG).show()

            }
            //Toast.makeText(this,str,Toast.LENGTH_LONG).show()
            //Toast.makeText(this,"entered button",Toast.LENGTH_LONG).show()

        }
        eventbtn.setOnClickListener(){

            val n=findViewById<EditText>(R.id.name).text.toString()
            val intent = Intent(this, page2::class.java)
            intent.putExtra("usr_name",n)
            startActivity(intent)

        }

        showbtn.setOnClickListener()
        {
            val n=findViewById<EditText>(R.id.name).text.toString()
            val ev=event.selectedItem.toString()
            val date="${dates.month}/${dates.dayOfMonth}/${dates.year}"
            val intent = Intent(this, displaydetails::class.java)
            intent.putExtra("name",n)
            intent.putExtra("event",ev)
            intent.putExtra("date",date)
            startActivity(intent)
        }


    }

}