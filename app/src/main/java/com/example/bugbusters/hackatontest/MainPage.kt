package com.example.bugbusters.hackatontest
import android.app.FragmentTransaction
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_page.*


class MainPage : AppCompatActivity(),EventFragment.OnFragmentInteractionListener {

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


//
    }

    fun change (){
        setContentView(R.layout.activity_main_page)
    }


    override fun onFragmentInteraction(uri: Uri?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
