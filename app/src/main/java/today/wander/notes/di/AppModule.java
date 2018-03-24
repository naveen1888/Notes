package today.wander.notes.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import today.wander.notes.data.DataManager;
import today.wander.notes.data.IDataManager;
import today.wander.notes.data.db.NoteDb;


@Module
abstract class AppModule {

    @Binds
    abstract Context provideContext(Application application);

    @Singleton
    @Provides
    static NoteDb provideNoteDb(Context context){
        return Room.databaseBuilder(context, NoteDb.class, NoteDb.DB_NAME)
                //.allowMainThreadQueries()//TO ALLOW DATABASE OPERATION ON MAIN THREAD
                .build();
    }

    @Singleton
    @Provides
    static IDataManager provideDataManager(NoteDb noteDb){
        return new DataManager(noteDb);
    }
}
