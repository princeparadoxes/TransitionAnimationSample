package com.princeparadoxes.transitionanimationsample.fragments;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.princeparadoxes.transitionanimationsample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutTransitionHSecondFragment extends Fragment {

    @Bind(R.id.layout_transitions_h_second_container)
    LinearLayout linearLayout;
    @Bind(R.id.layout_transitions_h_second_show_hide)
    View view;

    public LayoutTransitionHSecondFragment() {
    }

    public static LayoutTransitionHSecondFragment newInstance() {
        LayoutTransitionHSecondFragment fragment = new LayoutTransitionHSecondFragment();
        return fragment;
    }

    @OnClick(R.id.layout_transitions_h_second_fab)
    void onClick() {
        boolean visibility = view.getVisibility() == View.VISIBLE;
        view.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_transition_h_second_fragment, container, false);
        ButterKnife.bind(this, rootView);
        LayoutTransition layoutTransition = new LayoutTransition();
        linearLayout.setLayoutTransition(layoutTransition);
        //
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        float width = displayMetrics.widthPixels;
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,
                ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0f, width));
        layoutTransition.setAnimator(LayoutTransition.APPEARING,
                ObjectAnimator.ofFloat(view, View.TRANSLATION_X, width, 0f));
        return rootView;
    }
}