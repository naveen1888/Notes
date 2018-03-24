package today.wander.notes.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import today.wander.notes.data.db.DbController;
import today.wander.notes.data.db.IDbController;
import today.wander.notes.data.db.Note;
import today.wander.notes.data.db.NoteDb;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public class DataManager implements IDataManager {

    private final IDbController dbController;

    @Inject
    public DataManager(NoteDb noteDb) {
        this.dbController = new DbController(noteDb);
    }


    @Override
    public Observable<Long> add(Note note) {
        return this.dbController.add(note);
    }

    @Override
    public Flowable<List<Note>> getAll() {
        return dbController.getAll();
    }

}
