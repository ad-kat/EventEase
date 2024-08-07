package com.example.eventease

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Myadapter(private val context: Activity,
                private val arrayList:
                ArrayList<User>):ArrayAdapter<User>(context,
                                    R.layout.list_items,arrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater:LayoutInflater=LayoutInflater.from(context)
        val view: View=inflater.inflate(R.layout.list_items,null)



        val imageView:ImageView=view.findViewById(R.id.p_pic)
        val username:TextView=view.findViewById(R.id.personName)
        val rate:TextView=view.findViewById(R.id.Ratings)

        imageView.setImageResource(arrayList[position].imageid)
        username.text=arrayList[position].name
            rate.text=arrayList[position].Rating



        return view
    }
}