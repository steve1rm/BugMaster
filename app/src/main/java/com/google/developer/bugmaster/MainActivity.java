package com.google.developer.bugmaster;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, InsectItemSelectedListener {
    private static final String INSECT_LIST = "insect_data";
    private List<InsectDataModel> insectDataModelList;

    @BindView(R.id.recycler_view)
    RecyclerView rvInsects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        Log.d(MainActivity.class.getSimpleName(), "onCreate");
        DatabaseManager databaseManager = DatabaseManager.getInstance(this);
        databaseManager.queryAllInsects("friendlyName");
    }

    private void setupAdapter() {
        final LayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        rvInsects.setLayoutManager(layoutManager);
        final InsectAdapter insectAdapter = new InsectAdapter(insectDataModelList, MainActivity.this);
        rvInsects.setAdapter(insectAdapter);
        insectAdapter.notifyItemRangeInserted(0, insectDataModelList.size());
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
                Intent intent = new Intent(this, SettingsActivity.class);
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
        Log.d(MainActivity.class.getName(), "loadAllInsects cursor " + cursor.getCount());
        InsectInteractorMapper insectInteractorMapper = new InsectInteractorMapperImp();
        insectDataModelList = insectInteractorMapper.map(cursor);
        Log.d(MainActivity.class.getName(), "loadAllInsects InsectDataModel.size " + insectDataModelList.size());
        setupAdapter();
    }

    public void loadSingleInsect(final Cursor cursor) {
        cursor.moveToFirst();
    }

    @Override
    public void insectedItemSelected(@NotNull InsectDataModel insectDataModel) {
        final Intent intent = new Intent(MainActivity.this, InsectDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        Log.d(MainActivity.class.getName(), "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(MainActivity.class.getName(), "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(MainActivity.class.getName(), "onDestroy");
        super.onDestroy();
    }
}
