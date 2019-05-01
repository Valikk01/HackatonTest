package com.example.bugbusters.hackatontest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.ParseException
import java.text.SimpleDateFormat

class HabitsAdapter (private val context: Context, private val habitsList: List<Habits>) : RecyclerView.Adapter<HabitsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var habit: TextView
        var dot: TextView
        var add_inf: TextView

        init {
            habit = view.findViewById(R.id.habit)
            dot = view.findViewById(R.id.dot)
            add_inf = view.findViewById(R.id.add_inf)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.habit_list_row, parent, false)

        return MyViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val habit = habitsList[position]

        holder.habit.text = habit.Name_of_habits
        holder.add_inf.text = habit.Add_info
        // Displaying dot from HTML character code
        holder.dot.text = Html.fromHtml("&#8226;")


    }

    override fun getItemCount(): Int {
        return habitsList.size
    }


}