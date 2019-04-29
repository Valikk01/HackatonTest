package com.example.bugbusters.hackatontest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

var DATABASE_VERSION = 1
 val DATABASE_NAME = "habitsDb"
 val TABLE_CONSTANT = "Habits"

 val KEY_ID = "_id"
 val KEY_NAME_HABIT = "Name"
 val KEY_ADD_INFO = "Info"

class DBHelp(var context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_CONSTANT " +
                "($KEY_ID Integer PRIMARY KEY, $KEY_NAME_HABIT TEXT, $KEY_ADD_INFO TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("Drop table if exists $TABLE_CONSTANT")
        onCreate(db!!)
    }

    fun addHabits(habit: Habits): Boolean{                  //записує в базу данних
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

    fun getAllHabits():  MutableList<Habits>{               //показує шо знаходиться в базі данних
        var list : MutableList<Habits> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_CONSTANT
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do {
                var habit = Habits()
                habit.id = result.getString(result.getColumnIndex(KEY_ID)).toInt()
                habit.Name_of_habits = result.getString(result.getColumnIndex(KEY_NAME_HABIT))
                habit.Add_info = result.getString(result.getColumnIndex(KEY_ADD_INFO))
                list.add(habit)
            }while (result.moveToNext())

        }

        result.close()
        db.close()
        return list
    }

}