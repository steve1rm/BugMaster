package com.google.developer.bugmaster;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, InsectItemSelectedListener {
    private static final String INSECT_LIST = "insect_data";


    @BindView(R.id.recycler_view)
    RecyclerView rvInsects;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvInsects = (RecyclerView)findViewById(R.id.recycler_view);
        DatabaseManager databaseManager = new DatabaseManager(this);
        databaseManager.queryAllInsects("friendlyName");
    }

    private void setupAdapter(List<InsectDataModel> insectDataModelList) {
        Log.d(MainActivity.class.getName(), "setupAdapter");
        final LayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        rvInsects.setLayoutManager(layoutManager);
        rvInsects.setHasFixedSize(true);
        final InsectAdapter insectAdapter = new InsectAdapter(insectDataModelList);
        rvInsects.setAdapter(insectAdapter);
        insectAdapter.notifyDataSetChanged();
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
        final List<InsectDataModel> insectDataModelList = insectInteractorMapper.map(cursor);
        /* data loaded with 24 items */
        setupAdapter(insectDataModelList);
    }

    public void loadSingleInsect(final Cursor cursor) {
        cursor.moveToFirst();
    }

    @Override
    public void insectedItemSelected(@NotNull InsectDataModel insectDataModel) {
        final Intent intent = new Intent(MainActivity.this, InsectDetailsActivity.class);
        startActivity(intent);
    }
}
