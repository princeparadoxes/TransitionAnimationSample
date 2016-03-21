package com.princeparadoxes.transitionanimationsample.dagger;


import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.firstStep.FirstStepView;
import com.princeparadoxes.transitionanimationsample.fragments.SceneFragment.secondStep.SecondStepView;

import dagger.Component;

@ApplicationScope
@Component(modules = {MainModule.class})
public interface MainComponent {
    /**
     * An initializer that creates the graph from an application.
     */
    void inject(FirstStepView view);

    void inject(SecondStepView view);

    void inject(MainApplication app);

    static final class Initializer {
        private Initializer() {
        } // No instances.

        static MainComponent init(MainApplication app) {
            return DaggerMainComponent.builder()
                    .mainModule(new MainModule(app))
                    .build();
        }
    }
}
