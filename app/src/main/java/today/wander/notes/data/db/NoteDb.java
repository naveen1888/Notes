package today.wander.notes.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDb extends RoomDatabase {

    public static final String DB_NAME = "NotesDb";

    public abstract INotesDao getNotesDao();

}
