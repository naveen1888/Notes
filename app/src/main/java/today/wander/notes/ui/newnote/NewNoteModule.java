package today.wander.notes.ui.newnote;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import today.wander.notes.data.IDataManager;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

@Module
public abstract class NewNoteModule {

    @Provides
    static NewNoteViewModel provideNewNoteViewModel(IDataManager dataManager) {
        return new NewNoteViewModel(dataManager);
    }

    @Binds
    abstract NewNoteView provideNewNoteVie(NewNoteActivity activity);

}
