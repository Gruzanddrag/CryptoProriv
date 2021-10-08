package ru.bruh.rosseti.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.bruh.rosseti.R;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private final Context context;

    CommentsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return context.getResources().getIntArray(R.array.positions)[position];
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false));
        } else {
            return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_first_level, parent, false));
        }
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView comment;
        private TextView author;
        private TextView date;


        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            comment = itemView.findViewById(R.id.comment);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);

            author.setText(context.getResources().getStringArray(R.array.names)[position]);

            comment.setText(context.getResources().getStringArray(R.array.comments)[position]);
        }
    }
}
