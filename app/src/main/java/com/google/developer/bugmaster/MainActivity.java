package com.google.developer.bugmaster;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.developer.bugmaster.data.DatabaseManager;
import com.google.developer.bugmaster.data.models.InsectDataModel;
import com.google.developer.bugmaster.domain.InsectInteractorMapper;
import com.google.developer.bugmaster.domain.InsectInteractorMapperImp;
import com.google.developer.bugmaster.presentation.InsectAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvInsects;

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

    /* Callback from database */
    public void loadAllInsects(final Cursor cursor) {
        InsectInteractorMapper insectInteractorMapper = new InsectInteractorMapperImp();
        final List<InsectDataModel> insectDataModelList = insectInteractorMapper.map(cursor);
        /* data loaded with 24 items */
        setupAdapter(insectDataModelList);
    }
}
