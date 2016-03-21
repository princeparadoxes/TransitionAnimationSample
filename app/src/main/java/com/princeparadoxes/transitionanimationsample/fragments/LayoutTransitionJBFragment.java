package com.princeparadoxes.transitionanimationsample.fragments;

import android.animation.LayoutTransition;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.princeparadoxes.transitionanimationsample.R;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutTransitionJBFragment extends Fragment {

    @Bind(R.id.layout_transitions_jb_container)
    LinearLayout linearLayout;
    @Bind(R.id.layout_transitions_jb_change)
    View view;
    @BindDimen(R.dimen.norm_size)
    int normSize;
    @BindDimen(R.dimen.big_size)
    int bigSize;

    boolean isBig;

    public LayoutTransitionJBFragment() {
    }

    public static LayoutTransitionJBFragment newInstance() {
        LayoutTransitionJBFragment fragment = new LayoutTransitionJBFragment();
        return fragment;
    }

    @OnClick(R.id.layout_transitions_jb_fab)
    void onClick() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = isBig ? normSize : bigSize;
        view.setLayoutParams(layoutParams);
        isBig = !isBig;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_transition_jb_fragment, container, false);
        ButterKnife.bind(this, rootView);
        LayoutTransition layoutTransition = new LayoutTransition();
        linearLayout.setLayoutTransition(layoutTransition);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        }
        return rootView;
    }
}