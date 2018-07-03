package com.google.developer.bugmaster.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.nfc.Tag;
import android.util.Log;

import com.google.developer.bugmaster.MainActivity;
import com.google.developer.bugmaster.data.db.InsectStorageImp;
import com.google.developer.bugmaster.domain.InsectStorageInteractorImp;

import java.lang.ref.WeakReference;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Singleton that controls access to the SQLiteDatabase instance
 * for this application.
 */
public class DatabaseManager {
    private WeakReference<MainActivity> mainActivity;

    private BugsDbHelper mBugsDbHelper;

    public DatabaseManager(MainActivity context) {
        mBugsDbHelper = new BugsDbHelper(context);
        mainActivity = new WeakReference<>(context);
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

        insectStorageInteractorImp.getAllSortedInsects(sortOrder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Cursor>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(Cursor cursor) {
                        mainActivity.get().loadAllInsects(cursor);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        disposable.dispose();
                    }
                });
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
                        stub -> Log.d("", ""),
                        throwable -> Log.e(DatabaseManager.class.getName(), throwable.getMessage()));
    }
}
