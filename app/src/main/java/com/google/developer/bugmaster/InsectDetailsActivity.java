package com.google.developer.bugmaster;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.developer.bugmaster.presentation.screens.InsectDetails;

import static com.google.developer.bugmaster.presentation.screens.InsectDetails.InsectDetailFragment;

public class InsectDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Implement layout and display insect details
        setContentView(R.layout.activity_insect_detail);

        final InsectDetails insectDetails = InsectDetailFragment.getNewInstance();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(MainActivity.INSECT_LIST, getIntent().getParcelableExtra(MainActivity.INSECT_LIST));
        insectDetails.setArguments(bundle);

        if(savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(
                    R.id.layout_activity_insect_detail,
                    insectDetails,
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
