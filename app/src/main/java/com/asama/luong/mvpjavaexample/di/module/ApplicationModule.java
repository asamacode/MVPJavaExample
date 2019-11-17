package com.asama.luong.mvpjavaexample.di.module;

import android.app.Application;
import android.content.Context;

import com.asama.luong.mvpjavaexample.BuildConfig;
import com.asama.luong.mvpjavaexample.R;
import com.asama.luong.mvpjavaexample.data.AppDataManager;
import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.data.db.AppDbHelper;
import com.asama.luong.mvpjavaexample.data.db.DbHelper;
import com.asama.luong.mvpjavaexample.data.network.ApiHeader;
import com.asama.luong.mvpjavaexample.data.network.ApiHelper;
import com.asama.luong.mvpjavaexample.data.network.AppApiHelper;
import com.asama.luong.mvpjavaexample.data.prefs.AppPreferencesHelper;
import com.asama.luong.mvpjavaexample.data.prefs.PreferencesHelper;
import com.asama.luong.mvpjavaexample.di.ApiInfo;
import com.asama.luong.mvpjavaexample.di.ApplicationContext;
import com.asama.luong.mvpjavaexample.di.DatabaseInfo;
import com.asama.luong.mvpjavaexample.di.PreferenceInfo;
import com.asama.luong.mvpjavaexample.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabasename() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provieDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
