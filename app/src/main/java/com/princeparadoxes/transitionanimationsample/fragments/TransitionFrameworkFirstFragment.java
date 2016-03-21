package com.princeparadoxes.transitionanimationsample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import com.princeparadoxes.transitionanimationsample.R;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransitionFrameworkFirstFragment extends Fragment {

    @Bind(R.id.transition_framework_first_container)
    FrameLayout root;
    @Bind(R.id.transition_framework_first_change)
    View view;
    @BindDimen(R.dimen.norm_size)
    int normSize;
    @BindDimen(R.dimen.big_size)
    int bigSize;

    boolean isBig;

    public TransitionFrameworkFirstFragment() {
    }

    public static TransitionFrameworkFirstFragment newInstance() {
        return new TransitionFrameworkFirstFragment();
    }

    @OnClick(R.id.transition_framework_first_fab)
    void onClick() {
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new BounceInterpolator());
        TransitionManager.beginDelayedTransition(root, transition);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = isBig ? normSize : bigSize;
        layoutParams.width = isBig ? normSize : bigSize;
        view.setLayoutParams(layoutParams);
        isBig = !isBig;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.transition_framework_first_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}