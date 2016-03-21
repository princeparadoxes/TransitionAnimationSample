package com.princeparadoxes.transitionanimationsample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.princeparadoxes.transitionanimationsample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutTransitionHFragment extends Fragment {

    @Bind(R.id.layout_transitions_h_container)
    LinearLayout container;

    public LayoutTransitionHFragment() {
    }

    public static LayoutTransitionHFragment newInstance() {
        LayoutTransitionHFragment fragment = new LayoutTransitionHFragment();
        return fragment;
    }

    @OnClick(R.id.layout_transitions_h_fab)
    void onClick() {
        addItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_transition_h_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void addItem() {
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(getContext()).inflate(
                R.layout.layout_transition_h_item, container, false);

        ((TextView) newView.findViewById(android.R.id.text1)).setText("New View");

        newView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container.removeView(newView);
            }
        });
        container.addView(newView, 0);
    }
}