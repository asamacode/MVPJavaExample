package com.asama.luong.mvpjavaexample.data.db;

import android.content.Context;

import com.asama.luong.mvpjavaexample.data.db.model.DaoMaster;
import com.asama.luong.mvpjavaexample.di.ApplicationContext;
import com.asama.luong.mvpjavaexample.di.DatabaseInfo;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context,
                        @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
