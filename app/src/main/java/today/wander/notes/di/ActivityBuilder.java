package today.wander.notes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import today.wander.notes.ui.dashboard.DashboardActivity;
import today.wander.notes.ui.dashboard.DashboardModule;
import today.wander.notes.ui.newnote.NewNoteActivity;
import today.wander.notes.ui.newnote.NewNoteModule;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = DashboardModule.class)
    abstract DashboardActivity bindDashboardActivity();

    @ContributesAndroidInjector(modules = NewNoteModule.class)
    abstract NewNoteActivity bindNewNoteActivity();
}
