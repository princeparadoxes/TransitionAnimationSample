package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.firstStep;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.princeparadoxes.transitionanimationsample.R;
import com.princeparadoxes.transitionanimationsample.dagger.MainApplication;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.SceneSwitcher;
import com.transitionseverywhere.TransitionManager;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstStepView extends FrameLayout {

    @Bind(R.id.scene_first_scene_name)
    protected EditText name;
    @Inject
    FirstStepPresenter presenter;
    @Bind(R.id.scene_first_step_next)
    View transitionButton;
    @Bind(R.id.scene_first_image_0)
    ImageView image0;
    @Bind(R.id.scene_first_image_1)
    ImageView image1;
    @Bind(R.id.scene_first_image_2)
    ImageView image2;
    private ImageView lastClicked;

    public FirstStepView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            MainApplication.get(getContext()).component().inject(this);
        }
    }

    @OnClick(R.id.scene_first_step_next)
    protected void toNextScene() {
        presenter.toSecondScene(name.getText().toString());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ButterKnife.bind(this);
        TransitionManager.setTransitionName(transitionButton, SceneSwitcher.TRANSITION_BUTTON);
        TransitionManager.setTransitionName(name, SceneSwitcher.TRANSITION_NAME);
        presenter.takeView(this);
        name.setText(presenter.getName());
        final List<ImageView> views = Arrays.asList(image0, image1, image2);
        for (int i = 0; i < 3; i++) {
            views.get(i).setAlpha(0.5f);
            final int finalI = i;
            TransitionManager.setTransitionName(views.get(i), ""); 
            if (presenter.getLastSelected() != -1 && presenter.getLastSelected() == i){
                TransitionManager.setTransitionName(views.get(finalI), SceneSwitcher.TRANSITION_IMAGE);
            }
            views.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lastClicked != null) {
                        lastClicked.setAlpha(0.5f);
                    }
                    views.get(finalI).setAlpha(1.0f);
                    lastClicked = views.get(finalI);
                    switch (finalI) {
                        case 0:
                            presenter.setLastSelected(0);
                            presenter.setImage(R.drawable.mountain_0);
                            break;
                        case 1:
                            presenter.setLastSelected(1);
                            presenter.setImage(R.drawable.mountain_1);
                            break;
                        case 2:
                            presenter.setLastSelected(2);
                            presenter.setImage(R.drawable.mountain_2);
                            break;
                    }
                    TransitionManager.setTransitionName(views.get(finalI), SceneSwitcher.TRANSITION_IMAGE);
                }
            });
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        presenter.dropView(this);
        super.onDetachedFromWindow();
    }

}
