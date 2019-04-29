package com.example.bugbusters.hackatontest


import android.app.FragmentTransaction
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.fragment_event.*


class MainPage : AppCompatActivity(),EventFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    lateinit var newEvent : EventFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        setSupportActionBar(toolbar)

        newEvent = EventFragment.newInstance()

        fab.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame,newEvent)
                .addToBackStack(newEvent.toString())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }




    }





    fun change (){
        setContentView(R.layout.activity_main_page)
    }



}
