package com.princeparadoxes.transitionanimationsample.fragments.SceneFragment;

import android.view.Gravity;

import com.princeparadoxes.transitionanimationsample.R;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.ChangeImageTransform;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;

/**
 * Created by Danil on 20.03.2016.
 */
public class SceneSwitcher {
    public static final String NAME = "name";
    public static final String IMAGE = "image";
    public static final String TRANSITION_BUTTON = "transition.button";
    public static final String TRANSITION_NAME = "transition.name";
    public static final String TRANSITION_IMAGE = "transition.image";
    private static Scene firstStepScene;
    private static Scene secondStepScene;

    public static void setFirstStepScene(Scene firstStepScene) {
        SceneSwitcher.firstStepScene = firstStepScene;
    }

    public static void setSecondStepScene(Scene secondStepScene) {
        SceneSwitcher.secondStepScene = secondStepScene;
    }

    public static void toFirstScene() {
        TransitionSet set = new TransitionSet();
        Slide tittle = new Slide(Gravity.TOP);
        tittle.addTarget(R.id.scene_first_step_tittle);
        set.addTransition(tittle);
        set.addTransition(new ChangeBounds());
        ChangeImageTransform image = new ChangeImageTransform();
        image.addTarget(SceneSwitcher.TRANSITION_IMAGE);
        set.addTransition(image);
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        set.setDuration(350);
        TransitionManager.go(firstStepScene, set);
    }

    public static void toSecondScene() {
        TransitionSet set = new TransitionSet();
        Slide tittle = new Slide(Gravity.TOP);
        tittle.addTarget(R.id.scene_first_step_tittle);
        set.addTransition(tittle);
        set.addTransition(new ChangeBounds());
        ChangeImageTransform image = new ChangeImageTransform();
        image.addTarget(SceneSwitcher.TRANSITION_IMAGE);
        set.addTransition(image);
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        set.setDuration(350);
        TransitionManager.go(secondStepScene, set);
    }
}
