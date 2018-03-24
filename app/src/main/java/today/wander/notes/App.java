package today.wander.notes;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import today.wander.notes.di.AppComponent;
import today.wander.notes.di.DaggerAppComponent;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
