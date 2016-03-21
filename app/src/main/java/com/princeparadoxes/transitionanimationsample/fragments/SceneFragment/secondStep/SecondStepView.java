package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.secondStep;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.princeparadoxes.transitionanimationsample.R;
import com.princeparadoxes.transitionanimationsample.dagger.MainApplication;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.SceneSwitcher;
import com.transitionseverywhere.TransitionManager;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondStepView extends FrameLayout {

    @Inject
    SecondStepPresenter presenter;

    @Bind(R.id.scene_second_scene_name)
    TextView name;

    @Bind(R.id.scene_second_step_previous)
    View transitionButton;
    @Bind(R.id.scene_second_scene_image)
    ImageView transitionImage;

    @OnClick(R.id.scene_second_step_previous)
    protected void toFirstScene() {
        presenter.toFirstScene();
    }

    public SecondStepView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            MainApplication.get(getContext()).component().inject(this);
        }

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ButterKnife.bind(this);
        presenter.takeView(this);
        TransitionManager.setTransitionName(transitionButton, SceneSwitcher.TRANSITION_BUTTON);
        TransitionManager.setTransitionName(name, SceneSwitcher.TRANSITION_NAME);
        TransitionManager.setTransitionName(transitionImage, SceneSwitcher.TRANSITION_IMAGE);
        name.setText(presenter.getName());
        transitionImage.setImageResource(presenter.getImage());
    }

    @Override
    protected void onDetachedFromWindow() {
        presenter.dropView(this);
        super.onDetachedFromWindow();
    }
}
