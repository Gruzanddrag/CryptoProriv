package ru.bruh.rosseti.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.bruh.rosseti.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private final Context context;

    MessageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(position);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
            return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_left, parent, false));
        else
            return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_right, parent, false));

    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView message;


        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            message = itemView.findViewById(R.id.message);
            message.setText(context.getResources().getStringArray(R.array.chat)[position]);
        }
    }
}
