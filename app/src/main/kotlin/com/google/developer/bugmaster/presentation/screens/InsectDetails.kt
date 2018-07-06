package com.google.developer.bugmaster.presentation.screens


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.developer.bugmaster.MainActivity
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import kotlinx.android.synthetic.main.insect_detail.*
import org.parceler.Parcels

/**
 * A simple [Fragment] subclass.
 *
 */
class InsectDetails : Fragment() {
    private lateinit var insectDataModel: InsectDataModel

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
        val view = inflater.inflate(R.layout.insect_detail, container, false)
        val bundle = arguments
        insectDataModel = Parcels.unwrap<InsectDataModel>(bundle?.getParcelable(MainActivity.INSECT_LIST))

        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvFriendlyName.text = insectDataModel.friendlyName
        tvScientificName.text = insectDataModel.scientificName
        tvClassification.text = insectDataModel.classification
        ivInsect.setImageDrawable(getImageAsset())
    }

    private fun getImageAsset(): Drawable {
        val assetManager = activity?.assets
        val inputStream = assetManager?.open(insectDataModel.imageAsset)

        return Drawable.createFromStream(inputStream, null)
    }
}
