package today.wander.notes.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

@Dao
public interface INotesDao {

    @Query("SELECT * FROM Note ORDER BY timestamp DESC ")
    Flowable<List<Note>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long add(Note note);

   /* @Insert
    long[] add(List<Note> notes);

    @Update
    int update(Note note);

    @Delete
    void delete(Note note);*/
}
