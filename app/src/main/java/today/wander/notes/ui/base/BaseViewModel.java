package today.wander.notes.ui.base;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by Naveen Rawat on 23/3/18.
 * for Notes
 */

public class BaseViewModel<V extends BaseView> extends ViewModel{

    @Inject
    V view;

    public V getView() {
        return view;
    }
}
