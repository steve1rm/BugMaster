package com.google.developer.bugmaster.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.developer.bugmaster.R
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectBugImageAdapterDelegate : ItemDelegate<CustomBugImageViewHolder, InsectAdapterItemType.InsectImage> {
    private lateinit var context: Context

    override fun itemType(): Class<out InsectAdapterItemType.InsectImage> {
        return InsectAdapterItemType.InsectImage::class.java
    }

    override fun createViewHolder(parent: ViewGroup): CustomBugImageViewHolder {
        this.context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return CustomBugImageViewHolder(inflater.inflate(R.layout.bug_image_item, parent, false))
    }

    override fun bindViewHolder(viewHolder: CustomBugImageViewHolder, item: InsectAdapterItemType.InsectImage) {
        viewHolder.ivBugImage.setImageDrawable(getImageAsset(item.insectTypeImage))
    }

    private fun getImageAsset(insectDataModel: InsectDataModel): Drawable {
        val assetManager = this.context.assets
        val inputStream = assetManager?.open(insectDataModel.imageAsset)

        return Drawable.createFromStream(inputStream, null)
    }

}