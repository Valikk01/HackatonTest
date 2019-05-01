package com.example.bugbusters.hackatontest


import android.app.FragmentTransaction
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.fragment_event.*
import java.util.ArrayList


class MainPage : AppCompatActivity(),EventFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    private var mAdapter: HabitsAdapter? = null
    private val habitsList = ArrayList<Habits>()
    private var coordinatorLayout: CoordinatorLayout? = null
    private var recyclerView: RecyclerView? = null

    private var db: DBHelp? = null


    lateinit var newEvent : EventFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        setSupportActionBar(toolbar)

        newEvent = EventFragment.newInstance()

        coordinatorLayout = findViewById(R.id.coordinator_layout)
        recyclerView = findViewById(R.id.recycler_view)

        db = DBHelp(this)
        habitsList.addAll(db!!.getAllHabits())

        fab.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame,newEvent)
                .addToBackStack(newEvent.toString())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }



        mAdapter = HabitsAdapter(this, habitsList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.addItemDecoration(MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16))
        recyclerView!!.adapter = mAdapter




    }










    fun change (){
        setContentView(R.layout.activity_main_page)
    }



}
