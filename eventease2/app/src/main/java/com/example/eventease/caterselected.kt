package com.example.eventease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import com.example.eventease.databinding.ActivityMainBinding

class caterselected: AppCompatActivity() {

    private lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.decor_details)

        val intent = intent
        val usr_name = intent.getStringExtra("usr_name")

        Toast.makeText(this,"$usr_name",Toast.LENGTH_SHORT).show()


        val listview: ListView=findViewById(R.id.listview)

        val imageid= intArrayOf(
            R.drawable.cat6,R.drawable.cat5,R.drawable.cat4,
            R.drawable.cat3,R.drawable.cat2,R.drawable.cat)

        val names= arrayOf(
            "Anjani Jaanva", "Chanchala Kripal","Shubhanshi Srinivasa",
            "Saksham Sneha", "Akriti Verma","Supriya Chawla"
        )
        val venues= arrayOf(
            "Ranchi", "Pokhara","Nainital",
            "Patna", "Raipur","Amritsar"
        )

        val emails= arrayOf(
            "anjani@gmail.com", "chanchal@gmail.com","shubhi@gmail.com",
            "saksham@gmail.com", "akriti@gmail.com","supriya@gmail.com"
        )

        val rates= arrayOf(
            "3.0/5", "3.5/5","4.5/5",
            "4.2/5", "4.0/5","3.8/5"

        )
        val pnos= arrayOf(
            "8855974859", "8957518147","7087249552",
            "8855974859", "8957518147","7087249552"
        )

        val price= arrayOf(
            "Rs.23000", "Rs.21000","Rs.18000",
            "Rs.19600", "Rs.22500","Rs.18000"
        )

        userArrayList=ArrayList()

        for(i in names.indices){
            val user=User(names[i],venues[i],emails[i],
                pnos[i],rates[i], imageid[i],price[i])

            userArrayList.add(user)

        }


        //binding.listview.adapter=Myadapter(this,userArrayList)
        val adapter=Myadapter(this, userArrayList)
        listview.adapter=adapter

        listview.setOnItemClickListener { _, _, position, id ->
            val name_selt=names[position]
            val venue_selt=venues[position]
            val email_selt=emails[position]
            val pnos_selt=pnos[position]
            val rate_selt=rates[position]
            val img_selt=imageid[position]
            val price_selt=price[position]

            val i= Intent(this,Personselected::class.java)

            i.putExtra("usr_name",usr_name)
            i.putExtra("booking","CATERING")
            i.putExtra("name",name_selt)
            i.putExtra("venue",venue_selt)
            i.putExtra("email",email_selt)
            i.putExtra("pnos",pnos_selt)
            i.putExtra("rate",rate_selt)
            i.putExtra("imgpic",img_selt)
            i.putExtra("b_price",price_selt)
            startActivity(i)

            //Toast.makeText(this,"name_selt", Toast.LENGTH_SHORT).show()
        }
    }
}