package com.example.bugbusters.hackatontest

import android.content.Context
import android.graphics.drawable.VectorDrawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import android.widget.RadioGroup
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [EventFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [EventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_event, container,
            false)
        var btnsave = view.findViewById<Button>(R.id.button_save_and_exit)
        var text_hab = view.findViewById<EditText>(R.id.editText_habit)
        var text_inf = view.findViewById<EditText>(R.id.editText_add)
        var btnshow = view.findViewById<Button>(R.id.button_save_and_create_new)
        var text_view = view.findViewById<TextView>(R.id.textView3)
        var radiomood = view.findViewById<RadioGroup>(R.id.radioMood)


        var db = DBHelp(context)

        btnsave.setOnClickListener(View.OnClickListener{

            val checked = radiomood.checkedRadioButtonId

            if (text_hab.text.toString().length>0 && checked>-1){
                var habit = Habits(text_hab.text.toString(),text_inf.text.toString(),checked )
                db.addHabits(habit)

            }else{
                Toast.makeText(context,"Enter the name of habit and mood",Toast.LENGTH_SHORT).show()
            }



        })

        btnshow.setOnClickListener(View.OnClickListener {
            var data = db.getAllHabits()
            text_view.text = ""
            for (i in 0..(data.size - 1)){

                        text_view.append(
                            data.get(i).id.toString() + ") " + data.get(i).Name_of_habits
                                    + " " + data.get(i).Add_info + " " + data.get(i).Mood + "\n")

            }
        })

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener") as Throwable
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment EventFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): EventFragment {
            val fragment = EventFragment()
            val args = Bundle()

            return fragment
        }
    }
}// Required empty public constructor
