package com.google.developer.bugmaster.data;

import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.developer.bugmaster.R;
import com.google.developer.bugmaster.data.db.InsectContract;
import com.google.developer.bugmaster.data.db.InsectStorageImp;
import com.google.developer.bugmaster.domain.InsectStorageInteractorImp;
import com.google.developer.bugmaster.data.entities.InsectEntity;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.google.developer.bugmaster.data.db.InsectContract.CREATE_STATEMENT;

/**
 * Database helper class to facilitate creating and updating
 * the database from the chosen schema.
 */
public class BugsDbHelper extends SQLiteOpenHelper {
    private static final String TAG = BugsDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "bug_master.db";
    private static final int DATABASE_VERSION = 5;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    //Used to read data from res/ and assets/
    private Resources mResources;

    public BugsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mResources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: Create and fill the database
        try {
            db.execSQL(CREATE_STATEMENT);
            readInsectsFromResources(db);
        }
        catch(SQLException ex) {
            Log.e(TAG, ex.getMessage());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Handle database version upgrades
        if(oldVersion < DATABASE_VERSION) {
            try {
                db.execSQL(InsectContract.DROP_STATMENT);
                db.execSQL(CREATE_STATEMENT);
            }
            catch(SQLException ex) {
                Log.e(TAG, ex.getMessage());
            }
        }
    }

    /**
     * Streams the JSON data from insect.json, parses it, and inserts it into the
     * provided {@link SQLiteDatabase}.
     *
     * @param db Database where objects should be inserted.
     * @throws IOException
     * @throws JSONException
     */
    private void readInsectsFromResources(SQLiteDatabase db) throws IOException, JSONException {
        StringBuilder builder = new StringBuilder();
        InputStream in = mResources.openRawResource(R.raw.insects);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        //Parse resource into key/values
        final String rawJson = builder.toString();
        //TODO: Parse JSON data and insert into the provided database instance
        final Gson gson = new Gson();
        final InsectEntity insertEntity = gson.fromJson(rawJson, InsectEntity.class);
        final InsectStorageImp insectStorageImp = new InsectStorageImp(db);
        final InsectStorageInteractorImp insectStorageInteractorImp = new InsectStorageInteractorImp(insectStorageImp);

        compositeDisposable.add(insectStorageInteractorImp.saveInsectToDatabase(insertEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Completable::error)
                .subscribe(
                        db::close,
                        error -> Log.e(TAG, "OnError Insects: " + error.getMessage())));
    }
}
