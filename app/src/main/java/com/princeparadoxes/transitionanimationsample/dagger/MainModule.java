package com.princeparadoxes.transitionanimationsample.dagger;

import android.app.Application;
import android.os.Bundle;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainModule {
    public static final String SCENES_DATA = "scenes.data";
    private final MainApplication app;

    public MainModule(MainApplication app) {
        this.app = app;
    }

    @Provides
    @ApplicationScope
    Application provideApplication() {
        return app;
    }

    @Provides
    @Named(SCENES_DATA)
    @ApplicationScope
    Bundle provideScenesData() {
        return new Bundle();
    }

}
