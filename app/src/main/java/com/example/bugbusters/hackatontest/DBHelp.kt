package com.example.bugbusters.hackatontest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

var DATABASE_VERSION = 1
 var DATABASE_NAME = "habitsDb"
 var TABLE_CONSTANT = "Habits"

 var KEY_ID = "_id"
 var KEY_NAME_HABIT = "Name"
 var KEY_ADD_INFO = "Info"

class DBHelp(var context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("Create table " + TABLE_CONSTANT + "(" + KEY_ID
                + " integer primary key" + KEY_NAME_HABIT + " text," + KEY_ADD_INFO + " text" + ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented")
    }

    fun addHabits(habit: Habits): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME_HABIT, habit.Name_of_habits)
        values.put(KEY_ADD_INFO, habit.Add_info)
        val _success = db.insert(TABLE_CONSTANT, null, values)
        if (_success == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    fun getAllHabits(): String {
        var allHabits: String = ""
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_CONSTANT"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(KEY_ID))
                    var nameOfHabit = cursor.getString(cursor.getColumnIndex(KEY_NAME_HABIT))
                    var addInfo = cursor.getString(cursor.getColumnIndex(KEY_ADD_INFO))

                    allHabits = "$allHabits\n$id $nameOfHabit $addInfo"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allHabits
    }

}