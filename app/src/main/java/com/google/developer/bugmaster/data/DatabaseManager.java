package com.google.developer.bugmaster.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

import com.google.developer.bugmaster.data.db.InsectContract;
import com.google.developer.bugmaster.data.db.InsectStorageImp;
import com.google.developer.bugmaster.domain.InsectStorageInteractorImp;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Singleton that controls access to the SQLiteDatabase instance
 * for this application.
 */
public class DatabaseManager {
    private static DatabaseManager sInstance;

    public static synchronized DatabaseManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }

        return sInstance;
    }

    private BugsDbHelper mBugsDbHelper;

    private DatabaseManager(Context context) {
        mBugsDbHelper = new BugsDbHelper(context);
    }

    /**
     * Return a {@link Cursor} that contains every insect in the database.
     *
     * @param sortOrder Optional sort order string for the query, can be null
     * @return {@link Cursor} containing all insect results.
     */
    public Cursor queryAllInsects(String sortOrder) {
        //TODO: Implement the query

            final Cursor cursor = mBugsDbHelper.getReadableDatabase().query(
                    InsectContract.TABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            mBugsDbHelper.close();
            cursor.close();

            return cursor;

/*
        final InsectStorageImp insectStorageImp = new InsectStorageImp(mBugsDbHelper.getReadableDatabase());

        return insectStorageImp.queryAndSort(sortOrder);
*/

/*

        final InsectStorageInteractorImp insectStorageInteractorImp
                = new InsectStorageInteractorImp(new InsectStorageImp(mBugsDbHelper.getReadableDatabase()));

        insectStorageInteractorImp.getAllSortedInsects(sortOrder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Cursor>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Cursor cursor) {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
*/
    }

    /**
     * Return a {@link Cursor} that contains a single insect for the given unique id.
     *
     * @param id Unique identifier for the insect record.
     * @return {@link Cursor} containing the insect result.
     */
    public Cursor queryInsectsById(int id) {
        //TODO: Implement the query
        final InsectStorageImp insectStorageImp = new InsectStorageImp(mBugsDbHelper.getReadableDatabase());

        return insectStorageImp.queryOnId(id);

/*
        final InsectStorageInteractorImp insectStorageInteractorImp
                = new InsectStorageInteractorImp(new InsectStorageImp(mBugsDbHelper.getReadableDatabase()));

        insectStorageInteractorImp.getInsectOnID(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Cursor>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Cursor cursor) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
*/
    }
}
