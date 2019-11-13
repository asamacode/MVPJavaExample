package com.asama.luong.mvpjavaexample.di.component;

import android.app.Application;
import android.content.Context;

import com.asama.luong.mvpjavaexample.MvpApp;
import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.di.ApplicationContext;
import com.asama.luong.mvpjavaexample.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp mvpApp);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDatamanager();
}
