package com.google.developer.bugmaster.presentation.screens


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.developer.bugmaster.MainActivity
import com.google.developer.bugmaster.R


/**
 * A simple [Fragment] subclass.
 *
 */
class InsectDetails : Fragment() {
    companion object InsectDetailFragment {
        val tag: String by lazy {
            InsectDetails::class.java.simpleName
        }

        val newInstance by lazy {
            InsectDetails()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val insectDataModel = arguments?.get(MainActivity.INSECT_LIST)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.insect_detail, container, false)
    }
}
