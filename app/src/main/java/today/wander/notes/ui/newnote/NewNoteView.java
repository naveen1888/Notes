package today.wander.notes.ui.newnote;

import today.wander.notes.data.db.Note;
import today.wander.notes.ui.base.BaseView;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public interface NewNoteView extends BaseView {

    void save(Note note);
}
