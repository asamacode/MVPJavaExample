package com.asama.luong.mvpjavaexample;

import android.app.Application;

import com.asama.luong.mvpjavaexample.di.component.ApplicationComponent;
import com.asama.luong.mvpjavaexample.di.component.DaggerApplicationComponent;
import com.asama.luong.mvpjavaexample.di.module.ApplicationModule;

public class MvpApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
