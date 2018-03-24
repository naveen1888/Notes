package today.wander.notes.ui.newnote;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import today.wander.notes.R;
import today.wander.notes.data.db.Note;
import today.wander.notes.databinding.ActivityNewNoteBinding;

/**
 * Created by Naveen Rawat on 23/3/18.
 * for Notes
 */

public class NewNoteActivity extends DaggerAppCompatActivity implements NewNoteView {

    private static final String PARAM_NOTE="note";

    @Inject
    NewNoteViewModel viewModel;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, NewNoteActivity.class);
    }

    public static Intent getStartIntent(Context context, Note note) {
        Intent intent=new Intent(context, NewNoteActivity.class);
        intent.putExtra(PARAM_NOTE, note);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewNoteBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_new_note);
        binding.setNewNote(viewModel);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Note note=getIntent().getParcelableExtra(PARAM_NOTE);
        if(note==null) {
            note = new Note();
        }
        viewModel.setNote(note);
    }

    @Override
    public void save(Note note) {
        Log.i("Note", "saved");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        viewModel.saveNote();
        super.onBackPressed();
    }
}
