package com.google.developer.bugmaster.presentation.adapters

import com.google.developer.bugmaster.presentation.core.BaseDelegateAdapter
import com.google.developer.bugmaster.presentation.core.ItemDelegate

class InsectAdapter(insectBugImageDelegate: ItemDelegate<CustomBugImageViewHolder, InsectAdapterItemType.InsectImage>,
                    insectDescriptionDelegate: ItemDelegate<CustomInsectViewHolder, InsectAdapterItemType.InsectDescription>)
    : BaseDelegateAdapter<InsectAdapterItemType>(
        insectBugImageDelegate,
        insectDescriptionDelegate)

