package today.wander.notes.ui.newnote;

import android.databinding.ObservableField;
import android.text.TextUtils;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import today.wander.notes.data.IDataManager;
import today.wander.notes.data.db.Note;
import today.wander.notes.ui.base.BaseViewModel;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public class NewNoteViewModel extends BaseViewModel<NewNoteView> {

    private final ObservableField<String> title = new ObservableField<>();
    private final ObservableField<String> text = new ObservableField<>();

    private IDataManager dataManager;
    private Note note;


    public NewNoteViewModel(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableField<String> getText() {
        return text;
    }

    public void setNote(Note note) {
        this.note = note;
        title.set(note.getTitle());
        text.set(note.getText());
    }

    public void saveNote() {
        if (this.note == null)
            this.note = new Note();

        String title = this.title.get();
        String text = this.text.get();
        if (!TextUtils.isEmpty(title) || !TextUtils.isEmpty(text)) {
            this.note.setTitle(TextUtils.isEmpty(title) ? "" : title);
            this.note.setText(TextUtils.isEmpty(text) ? "" : text);
            dataManager.add(note)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(aLong -> Log.i("Note", "saved"), Throwable::printStackTrace);
        }
    }
}
