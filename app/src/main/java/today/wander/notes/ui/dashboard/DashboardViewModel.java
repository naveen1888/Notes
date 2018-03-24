package today.wander.notes.ui.dashboard;

import android.databinding.ObservableField;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import today.wander.notes.data.IDataManager;
import today.wander.notes.data.db.Note;
import today.wander.notes.ui.base.BaseViewModel;

/**
 * Created by Naveen Rawat on 23/3/18.
 * for Notes
 */

public class DashboardViewModel extends BaseViewModel<DashboardView> {
    private ObservableField<List<Note>> listObservable = new ObservableField<>();
    private IDataManager dataManager;

    public DashboardViewModel(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ObservableField<List<Note>> getListObservable() {
        return listObservable;
    }

    public void setListObservable(List<Note> list) {
        this.listObservable.set(list);
    }

    public void loadAllNotes() {
        dataManager.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(notes -> {
                    Log.i("Notes", notes.toString());
                    if (notes.size() > 0) {
                        setListObservable(notes);
                    }
                }, Throwable::printStackTrace);
    }
}
