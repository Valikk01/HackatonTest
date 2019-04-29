package com.example.bugbusters.hackatontest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}


class Name {
    var id: Int = 0
    var userName: String? = null
    constructor(id: Int, userName: String) {
        this.id = id
        this.userName = userName
    }
    constructor(userName: String) {
        this.userName = userName
    }
}


