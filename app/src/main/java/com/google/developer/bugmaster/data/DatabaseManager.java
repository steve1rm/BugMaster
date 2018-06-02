package com.google.developer.bugmaster.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;

import com.google.developer.bugmaster.MainActivity;
import com.google.developer.bugmaster.data.db.InsectStorageImp;
import com.google.developer.bugmaster.domain.InsectStorageInteractorImp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Singleton that controls access to the SQLiteDatabase instance
 * for this application.
 */
public class DatabaseManager {
    private static DatabaseManager sInstance;
    private MainActivity mainActivity;

    public static synchronized DatabaseManager getInstance(MainActivity context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context);
        }

        return sInstance;
    }

    private BugsDbHelper mBugsDbHelper;

    private DatabaseManager(MainActivity context) {
        mBugsDbHelper = new BugsDbHelper(context);

        mainActivity = context;
    }

    /**
     * Return a {@link Cursor} that contains every insect in the database.
     *
     * @param sortOrder Optional sort order string for the query, can be null
     * @return {@link Cursor} containing all insect results.
     */
    @SuppressLint("CheckResult")
    public void queryAllInsects(String sortOrder) {
        //TODO: Implement the query
        final InsectStorageInteractorImp insectStorageInteractorImp
                = new InsectStorageInteractorImp(new InsectStorageImp(mBugsDbHelper.getReadableDatabase()));

        final Disposable disposable = insectStorageInteractorImp.getAllSortedInsects(sortOrder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        cursor -> mainActivity.loadAllInsects(cursor),
                        throwable -> Log.e(DatabaseManager.class.getName(), throwable.getMessage()));
    }

    /**
     * Return a {@link Cursor} that contains a single insect for the given unique id.
     *
     * @param id Unique identifier for the insect record.
     * @return {@link Cursor} containing the insect result.
     */
    public void queryInsectsById(int id) {
        //TODO: Implement the query
        final InsectStorageInteractorImp insectStorageInteractorImp
                = new InsectStorageInteractorImp(new InsectStorageImp(mBugsDbHelper.getReadableDatabase()));

        final Disposable disposable = insectStorageInteractorImp.getInsectOnID(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        cursor -> mainActivity.loadSingleInsect(cursor),
                        throwable -> Log.e(DatabaseManager.class.getName(), throwable.getMessage()));
    }
}
