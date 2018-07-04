package com.google.developer.bugmaster;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.developer.bugmaster.data.DatabaseManager;
import com.google.developer.bugmaster.data.models.InsectDataModel;
import com.google.developer.bugmaster.domain.InsectInteractorMapper;
import com.google.developer.bugmaster.domain.InsectInteractorMapperImp;
import com.google.developer.bugmaster.presentation.InsectAdapter;
import com.google.developer.bugmaster.presentation.screens.InsectItemSelectedListener;

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, InsectItemSelectedListener {
    public static final String INSECT_LIST = "insect_data";

    private List<InsectDataModel> insectDataModelList;

    @BindView(R.id.recycler_view)
    RecyclerView rvInsects;
    private Unbinder unbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupRecyclerView();

        if(savedInstanceState == null) {
            DatabaseManager databaseManager = new DatabaseManager(this);
            databaseManager.queryAllInsects("friendlyName");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        final Parcelable insectList = Parcels.wrap(insectDataModelList);
        outState.putParcelable(INSECT_LIST, insectList);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        insectDataModelList = Parcels.unwrap(savedInstanceState.getParcelable(INSECT_LIST));
        if(insectDataModelList != null) {
            loadDataIntoAdapter();
        }
    }

    private void loadDataIntoAdapter() {
        final InsectAdapter insectAdapter =
                new InsectAdapter(insectDataModelList, MainActivity.this);
        rvInsects.setAdapter(insectAdapter);
        insectAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        final LayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        rvInsects.setLayoutManager(layoutManager);
        rvInsects.setHasFixedSize(true);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort:
                //TODO: Implement the sort action
                return true;
            case R.id.action_settings:
                final Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Click events in Floating Action Button */
    @Override
    public void onClick(View v) {
        //TODO: Launch the quiz activity
    }

    public void loadAllInsects(final Cursor cursor) {
        InsectInteractorMapper insectInteractorMapper = new InsectInteractorMapperImp();
        insectDataModelList = insectInteractorMapper.map(cursor);
        /* data loaded with 24 items */
        loadDataIntoAdapter();
    }

    public void loadSingleInsect(final Cursor cursor) {
        cursor.moveToFirst();
    }

    @Override
    public void onInsectItemSelected(@NotNull InsectDataModel insectDataModel) {
        final Intent intent = new Intent(MainActivity.this, InsectDetailsActivity.class);
        final Parcelable parcelable = Parcels.wrap(insectDataModel);
        intent.putExtra(INSECT_LIST, parcelable);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
