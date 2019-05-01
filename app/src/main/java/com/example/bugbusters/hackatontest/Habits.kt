package com.example.bugbusters.hackatontest

class Habits {
    var id: Int = 0
    var Name_of_habits: String? = null
    var Add_info: String? = null
    var Mood: String? = null


    constructor(name:String, info:String, mood: Int){
        this.Name_of_habits = name
        this.Add_info = info
        this.Mood = mood.toString()

    }
    constructor(){
    }
}


