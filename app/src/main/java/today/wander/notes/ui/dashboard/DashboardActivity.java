package today.wander.notes.ui.dashboard;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import today.wander.notes.R;
import today.wander.notes.data.IDataManager;
import today.wander.notes.data.db.Note;
import today.wander.notes.databinding.ActivityDashboardBinding;
import today.wander.notes.ui.newnote.NewNoteActivity;

/**
 * Created by Naveen Rawat on 22/3/18.
 * for Notes
 */

public class DashboardActivity extends DaggerAppCompatActivity implements DashboardView {

    @Inject
    IDataManager dataManager;

    private RecyclerView recyclerView;

    @Inject
    DashboardViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDashboardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        binding.setView(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel.loadAllNotes();

        viewModel.getListObservable().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                displayNotes(viewModel.getListObservable().get());
            }
        });


    }

    @Override
    public void onClick(View view) {
        startActivity(NewNoteActivity.getStartIntent(this));
    }

    @Override
    public void displayNotes(List<Note> list) {

        AllNotesAdapter adapter = new AllNotesAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
