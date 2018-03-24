package today.wander.notes.ui.dashboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import today.wander.notes.data.db.Note;
import today.wander.notes.databinding.ItemNoteBinding;
import today.wander.notes.ui.newnote.NewNoteActivity;

/**
 * Created by Naveen Rawat on 23/3/18.
 * for Notes
 */

public class AllNotesAdapter extends RecyclerView.Adapter<AllNotesAdapter.MyViewHolder> {

    private Context context;
    private List<Note> list;

    AllNotesAdapter(Context context, List<Note> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemNoteBinding binding = ItemNoteBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ItemNoteBinding binding;

        MyViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        void bind(Note note) {
            binding.setNote(note);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            context.startActivity(NewNoteActivity.getStartIntent(context, list.get(getAdapterPosition())));
        }
    }
}
