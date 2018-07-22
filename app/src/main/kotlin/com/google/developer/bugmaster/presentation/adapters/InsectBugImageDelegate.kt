package com.google.developer.bugmaster.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.AdapterDelegate

class InsectBugImageDelegate(private val viewType: Int) : AdapterDelegate<MutableList<InsectDataModel>> {
    private lateinit var context: Context

    fun getViewType() = viewType

    override fun isForViewType(items: MutableList<InsectDataModel>, position: Int) =
            items[position].itemType == InsectItemType.IMAGE.type

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        this.context = parent.context
        val inflater = LayoutInflater.from(this.context)
        return CustomBugImageHolder(inflater.inflate(R.layout.bug_image_item, parent, false))
    }

    override fun onBindViewHolder(items: MutableList<InsectDataModel>, position: Int, viewHolder: RecyclerView.ViewHolder) {
        if(viewHolder is CustomBugImageHolder) {
            viewHolder.ivBugimage.setImageDrawable(getImageAsset(items[position]))
        }
    }

    private fun getImageAsset(insectDataModel: InsectDataModel): Drawable {
        val assetManager = this.context.assets
        val inputStream = assetManager?.open(insectDataModel.imageAsset)

        return Drawable.createFromStream(inputStream, null)
    }
}
