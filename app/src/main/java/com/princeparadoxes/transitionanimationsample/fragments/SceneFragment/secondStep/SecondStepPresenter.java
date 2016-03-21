package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.secondStep;

import android.os.Bundle;

import com.princeparadoxes.transitionanimationsample.dagger.ApplicationScope;
import com.princeparadoxes.transitionanimationsample.dagger.BasePresenter;
import com.princeparadoxes.transitionanimationsample.dagger.MainModule;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.SceneSwitcher;

import javax.inject.Inject;
import javax.inject.Named;


@ApplicationScope
public final class SecondStepPresenter extends BasePresenter<SecondStepView> {

    private final Bundle scenesData;


    @Inject
    public SecondStepPresenter(@Named(MainModule.SCENES_DATA)Bundle scenesData) {
        this.scenesData = scenesData;
    }

    @Override
    protected void onLoad() {
        super.onLoad();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void toFirstScene() {
        SceneSwitcher.toFirstScene();
    }

    public String getName() {
        String name = scenesData.getString(SceneSwitcher.NAME);
        return name == null ? "" : name;
    }

    public Integer getImage() {
        Integer image = scenesData.getInt(SceneSwitcher.IMAGE);
        return image;
    }
}
