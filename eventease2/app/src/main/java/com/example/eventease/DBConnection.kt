package com.example.eventease

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBConnection(var context: Context, var dbName:String,var dbVersion: Int): SQLiteOpenHelper(context,dbName,null,dbVersion) {

    companion object{
        val TABLE_NAME_USER = "userdetails"
        val TABLE_NAME_ORDER = "orderdetails"
        // Columns for userdetails table
        val ID_COL = "id"
        val NAME_COL = "name"
        val EVENT_COL = "event"
        val DATE_COL = "date"
        // Columns for orderdetails table
        val ORDER_ID_COL = "order_id"
        val BOOKING_COL = "booking"
        val PERSONNEL_COL = "person"
        val PHONE_COL="phone"
    }
    val userQuery = ("CREATE TABLE " + TABLE_NAME_USER + " ("
            + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COL + " TEXT," +
            EVENT_COL + " TEXT," +
            DATE_COL + " TEXT" +")")

    val orderQuery = ("CREATE TABLE " + TABLE_NAME_ORDER + " ("
            + ORDER_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COL + " TEXT, " +
            BOOKING_COL + " TEXT, " +
            PERSONNEL_COL + " TEXT, " +
            PHONE_COL + " TEXT)")


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(userQuery)
        db.execSQL(orderQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ORDER)
        onCreate(db)
    }

    fun insert(name : String, event : String, date : String ):Long{


        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, name)
        values.put(EVENT_COL, event)
        values.put(DATE_COL, date)

        val result:Long= db.insert(TABLE_NAME_USER, null, values)
        db.close()
        return result

    }
    fun insert_orders(name : String, booking : String, person : String, phone : String ):Long{


        val db:SQLiteDatabase = this.writableDatabase

        val values = ContentValues()

        values.put(NAME_COL, name)
        values.put(BOOKING_COL, booking)
        values.put(PERSONNEL_COL, person)
        values.put(PHONE_COL, phone)

        val result:Long= db.insert(DBConnection.TABLE_NAME_ORDER, null, values)
        db.close()
        return result

    }
    fun display(name:String):Cursor
    {

        val db:SQLiteDatabase=this.readableDatabase
       val query="select * from $TABLE_NAME_USER where $NAME_COL='$name'"
        val cursor: Cursor = db.rawQuery(query, null)
        return cursor
    }
    fun display_orders(name:String):Cursor
    {

        val db:SQLiteDatabase=this.readableDatabase
        val query="select * from $TABLE_NAME_ORDER where $NAME_COL='$name'"
        val cursor: Cursor =db.rawQuery(query,null)
        return cursor
    }
}