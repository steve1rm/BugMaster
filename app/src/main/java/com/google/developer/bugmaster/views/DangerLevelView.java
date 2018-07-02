package com.google.developer.bugmaster.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.google.developer.bugmaster.R;

//TODO: This class should be used in the insect list to display danger level
public class DangerLevelView extends AppCompatTextView {
    private int dangerLevel;

    public DangerLevelView(Context context) {
        super(context);
    }

    public DangerLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DangerLevelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDangerLevel(int dangerLevel) {
        //TODO: Update the view appropriately based on the level input
        this.dangerLevel = dangerLevel;
        setText(String.valueOf(dangerLevel));
        final GradientDrawable gradientDrawable = (GradientDrawable)getBackground();
        gradientDrawable.setColor(Color.parseColor(getDangerLevel()));
    }

    public String getDangerLevel() {
        //TODO: Report the current level back as an integer
        final String arrayColors[] = getResources().getStringArray(R.array.dangerColors);

        return arrayColors[dangerLevel - 1];
    }
}
