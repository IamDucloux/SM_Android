package com.fixware.smartnotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecycleViewAdapter extends RecyclerView.Adapter<NoteRecycleViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title, desc;
        private ImageView note;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textView_NoteTitle);
            desc = (TextView) itemView.findViewById(R.id.textView_Notedesc);
            note = (ImageView) itemView.findViewById(R.id.img_note);
        }



    }

    public List<Note> noteList;

    public NoteRecycleViewAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(noteList.get(position).getTitle());
        holder.desc.setText(noteList.get(position).getDescription());
        holder.note.setImageResource(noteList.get(position).getImg_note());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
