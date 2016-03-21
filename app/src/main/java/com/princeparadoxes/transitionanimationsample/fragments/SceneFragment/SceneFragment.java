package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.princeparadoxes.transitionanimationsample.R;
import com.transitionseverywhere.Scene;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SceneFragment extends Fragment {

    @Bind(R.id.transition_framework_first_container)
    FrameLayout rootScene;

    public SceneFragment() {
    }

    public static SceneFragment newInstance() {
        return new SceneFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.scene_fragment, container, false);
        ButterKnife.bind(this, rootView);
        SceneSwitcher.setFirstStepScene(Scene.getSceneForLayout(rootScene,
                R.layout.scene_first_step_view, getContext()));
        SceneSwitcher.setSecondStepScene(Scene.getSceneForLayout(rootScene,
                R.layout.scene_second_step_view, getContext()));
        SceneSwitcher.toFirstScene();
        return rootView;
    }


}