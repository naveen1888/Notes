package today.wander.notes.data.db;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public class DbController implements IDbController{

    private INotesDao notesDao;

    public DbController(NoteDb noteDb) {
        this.notesDao = noteDb.getNotesDao();
    }


    @Override
    public Flowable<List<Note>> getAll() {
        return this.notesDao.getAll();
    }

    @Override
    public Observable<Long> add(Note note) {
        return Observable.fromCallable(() -> notesDao.add(note));
    }
}
