package com.google.developer.bugmaster.presentation.screens


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.developer.bugmaster.R


/**
 * A simple [Fragment] subclass.
 *
 */
class InsectDetail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.insect_detail, container, false)
    }
}
