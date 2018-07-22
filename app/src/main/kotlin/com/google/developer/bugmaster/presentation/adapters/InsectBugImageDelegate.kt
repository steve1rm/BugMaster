package com.google.developer.bugmaster.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel

class InsectBugImageDelegate(private val viewType: Int) {

    private lateinit var context: Context

    fun getViewType() = viewType

    fun isForViewType(insectList: MutableList<InsectDataModel>, position: Int) =
            insectList[position].itemType == InsectItemType.IMAGE.type

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        this.context = parent.context
        val inflater = LayoutInflater.from(this.context)
        return CustomBugImageHolder(inflater.inflate(R.layout.bug_image_item, parent, false))
    }

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, insectList: MutableList<InsectDataModel>) {
        if(holder is CustomBugImageHolder) {
            holder.ivBugimage.setImageDrawable(getImageAsset(insectList[position]))
        }
    }

    private fun getImageAsset(insectDataModel: InsectDataModel): Drawable {
        val assetManager = this.context.assets
        val inputStream = assetManager?.open(insectDataModel.imageAsset)

        return Drawable.createFromStream(inputStream, null)
    }
}
