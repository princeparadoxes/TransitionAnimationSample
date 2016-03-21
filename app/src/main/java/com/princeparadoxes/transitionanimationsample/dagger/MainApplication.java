package com.princeparadoxes.transitionanimationsample.dagger;

import android.app.Application;
import android.content.Context;

/**
 * Created by Danil on 20.03.2016.
 */
public class MainApplication extends Application {

    private MainComponent component;

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        component = MainComponent.Initializer.init(this);
        component.inject(this);
    }

    public MainComponent component() {
        return component;
    }
}
