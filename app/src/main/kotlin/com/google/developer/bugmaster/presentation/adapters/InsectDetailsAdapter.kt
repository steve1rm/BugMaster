package com.google.developer.bugmaster.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.google.developer.bugmaster.data.models.InsectDataModel
import com.google.developer.bugmaster.presentation.core.AdapterDelegateManager
import com.google.developer.bugmaster.presentation.screens.InsectItemSelectedListener

class InsectDetailsAdapter(private val insectList: MutableList<InsectDataModel>,
                           private val insectItemSelectedListener: InsectItemSelectedListener,
                           private var insectDescriptionDelegate: InsectDescriptionDelegate,
                           private var insectBugImageDelegate: InsectBugImageDelegate)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegateManager: AdapterDelegateManager<MutableList<InsectDataModel>> = AdapterDelegateManager()

    init {
        insectDescriptionDelegate = InsectDescriptionDelegate(InsectItemType.DESCRIPTION.type)
        insectBugImageDelegate = InsectBugImageDelegate(InsectItemType.IMAGE.type)

        delegateManager.addDelegate(insectDescriptionDelegate)
        delegateManager.addDelegate(insectBugImageDelegate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateManager.onCreateViewHolder(parent, viewType)
/*
        return when(viewType) {
            InsectItemType.DESCRIPTION.type -> {
                insectDescriptionDelegate.onCreateViewHolder(parent)
            }
            InsectItemType.IMAGE.type -> {
                insectBugImageDelegate.onCreateViewHolder(parent)
            }
            else -> {
                throw UnsupportedOperationException("No delegate found")
                }
            }
*/
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateManager.onBindViewHolder(insectList, position, holder)

/*
        when(holder.itemViewType) {
            InsectItemType.DESCRIPTION.type -> {
                insectDescriptionDelegate.onBindViewHolder(insectList, position, holder)
            }

            InsectItemType.IMAGE.type -> {
                insectBugImageDelegate.onBindViewHolder(insectList, position, holder)
            }
        }
*/
    }

    override fun getItemCount(): Int {
        return insectList.size
    }

    override fun getItemViewType(position: Int): Int {
        return delegateManager.getItemViewType(insectList, position)

/*
        return if(insectDescriptionDelegate.isForViewType(insectList, position)) {
            insectDescriptionDelegate.getViewType()
        }
        else if(insectBugImageDelegate.isForViewType(insectList, position)) {
             insectBugImageDelegate.getViewType()
        }
        else {
            throw UnsupportedOperationException("No Delegate found")
        }
*/
    }
}
