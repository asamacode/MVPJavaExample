package com.asama.luong.mvpjavaexample.di.component;


import com.asama.luong.mvpjavaexample.di.PerActivity;
import com.asama.luong.mvpjavaexample.di.module.ActivityModule;
import com.asama.luong.mvpjavaexample.ui.about.AboutFragment;
import com.asama.luong.mvpjavaexample.ui.login.LoginActivity;
import com.asama.luong.mvpjavaexample.ui.main.MainActivity;
import com.asama.luong.mvpjavaexample.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(AboutFragment fragment);
}