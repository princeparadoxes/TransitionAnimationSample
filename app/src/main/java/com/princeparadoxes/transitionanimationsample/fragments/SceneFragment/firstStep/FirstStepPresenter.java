package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.firstStep;

import android.app.Application;
import android.os.Bundle;
import android.widget.ImageView;

import com.princeparadoxes.transitionanimationsample.R;
import com.princeparadoxes.transitionanimationsample.dagger.ApplicationScope;
import com.princeparadoxes.transitionanimationsample.dagger.BasePresenter;
import com.princeparadoxes.transitionanimationsample.dagger.MainModule;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.SceneSwitcher;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


@ApplicationScope
public final class FirstStepPresenter extends BasePresenter<FirstStepView> {

    private final Bundle scenesData;
    private FirstStepView view;
    private int lastSelected = -1;


    @Inject
    public FirstStepPresenter(@Named(MainModule.SCENES_DATA) Bundle scenesData,
                              Application application) {
        this.scenesData = scenesData;
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        view = getView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void toSecondScene(String name) {
        scenesData.putString(SceneSwitcher.NAME, name);
        SceneSwitcher.toSecondScene();
    }

    public String getName() {
        String name = scenesData.getString(SceneSwitcher.NAME);
        return name == null ? "" : name;
    }

    public int getLastSelected() {
        return lastSelected;
    }

    public void setLastSelected(int lastSelected) {
        this.lastSelected = lastSelected;
    }

    public void setImage(int res) {
        scenesData.remove(SceneSwitcher.NAME);
        scenesData.putInt(SceneSwitcher.IMAGE, res);
    }
}
