package today.wander.notes.data.db;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public interface IDbController {
    Observable<Long> add(Note note);
    Flowable<List<Note>> getAll();
}
