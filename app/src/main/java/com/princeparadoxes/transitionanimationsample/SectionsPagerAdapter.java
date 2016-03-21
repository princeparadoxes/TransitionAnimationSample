package com.princeparadoxes.transitionanimationsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.princeparadoxes.transitionanimationsample.fragments.LayoutTransitionHFragment;
import com.princeparadoxes.transitionanimationsample.fragments.LayoutTransitionHSecondFragment;
import com.princeparadoxes.transitionanimationsample.fragments.LayoutTransitionJBFragment;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.SceneFragment;
import com.princeparadoxes.transitionanimationsample.fragments.TransitionFrameworkFirstFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:case 0:
                return LayoutTransitionHFragment.newInstance();
            case 1:
                return LayoutTransitionHSecondFragment.newInstance();
            case 2:
                return LayoutTransitionJBFragment.newInstance();
            case 3:
                return TransitionFrameworkFirstFragment.newInstance();
            case 4:
                return SceneFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "LayoutTransitions H";
            case 1:
                return "LayoutTransitions H Second";
            case 2:
                return "LayoutTransitions JB";
            case 3:
                return "Transition Framework First";
            case 4:
                return "Scene Fragment";
        }
        return null;
    }
}
