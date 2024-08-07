package com.example.eventease

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventease.databinding.UserDisplayBinding

class displaydetails: AppCompatActivity() {
    private lateinit var n:TextView
    private lateinit var binding: UserDisplayBinding
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val name = intent.getStringExtra("name")
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()

        val db= DBConnection(this,"userdetails",1)
        val db2= DBConnection(this,"orderdetails",1)
        n=findViewById(R.id.details)

        binding.button.setOnClickListener{
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
            val cursor = db.display(name.toString())
            Toast.makeText(this,"$cursor",Toast.LENGTH_SHORT).show()
            binding.details.text = ""

            while(cursor?.moveToNext() == true){
                binding.details.append("Name:"+ cursor.getString(cursor.getColumnIndex(DBConnection.NAME_COL)) + "\n"
                        +"Event:"+ cursor.getString(cursor.getColumnIndex(DBConnection.EVENT_COL)) +"\n"
                        +"Date:"+ cursor.getString(cursor.getColumnIndex(DBConnection.DATE_COL)) + "\n\n")

            }



            val cursor2 = db2.display_orders(name.toString())
            binding.orders.text = ""

            while(cursor2?.moveToNext() == true){
                binding.orders.append("Professional:"+ cursor2.getString(cursor2.getColumnIndex(DBConnection.PERSONNEL_COL)) + "\n"
                        +"Booking for:"+ cursor2.getString(cursor2.getColumnIndex(DBConnection.BOOKING_COL)) +"\n"
                        +"Contact no.:"+ cursor2.getString(cursor2.getColumnIndex(DBConnection.PHONE_COL)) + "\n\n")

            }

            //cursor?.close()
            cursor2?.close()

        }





    }

}