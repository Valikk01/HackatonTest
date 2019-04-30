package com.example.bugbusters.hackatontest

class Habits {
    var id: Int = 0
    var Name_of_habits: String = ""
    var Add_info: String = ""
    var Mood: String = ""

    constructor(name:String, info:String, mood: Int){
        this.Name_of_habits = name
        this.Add_info = info
        this.Mood = mood.toString()
    }
    constructor(){
    }
}