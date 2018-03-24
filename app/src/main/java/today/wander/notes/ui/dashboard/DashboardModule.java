package today.wander.notes.ui.dashboard;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import today.wander.notes.data.IDataManager;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

@Module
public abstract class DashboardModule {

    @Binds
    abstract DashboardView provideDashboardView(DashboardActivity activity);

    @Provides
    static DashboardViewModel dashboardViewModel(IDataManager dataManager){
        return new DashboardViewModel(dataManager);
    }
}
