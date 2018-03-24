package today.wander.notes.ui.dashboard;

import android.view.View;

import java.util.List;

import today.wander.notes.data.db.Note;
import today.wander.notes.ui.base.BaseView;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public interface DashboardView extends BaseView {
    void onClick(View view);
    void displayNotes(List<Note> list);
}
