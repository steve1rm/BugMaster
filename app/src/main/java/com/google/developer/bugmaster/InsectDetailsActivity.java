package com.google.developer.bugmaster;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.google.developer.bugmaster.data.models.InsectDataModel;

import dart.Dart;

import static com.google.developer.bugmaster.presentation.screens.InsectDetails.InsectDetailFragment;


public class InsectDetailsActivity extends AppCompatActivity {
    @InjectExtra(MainActivity.INSECT_LIST)
    InsectDataModel insectDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Implement layout and display insect details
        setContentView(R.layout.activity_insect_detail);

        Dart.inject(this);

        if(savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(
                    R.id.layout_activity_insect_detail,
                    InsectDetailFragment.getNewInstance(),
                    InsectDetailFragment.getTag())
            .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
