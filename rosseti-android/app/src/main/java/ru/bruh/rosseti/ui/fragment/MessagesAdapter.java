package ru.bruh.rosseti.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.bruh.rosseti.R;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
    private final Context context;

    interface EventListener {
        void onItemClick(String name);
    }

    MessagesAdapter(Context context) {
        this.context = context;
    }

    private MessagesAdapter.EventListener listener;

    public void setListener(MessagesAdapter.EventListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(position);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messages, parent, false));
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView name;
        private TextView message;


        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);

            name.setText(context.getResources().getStringArray(R.array.names)[position]);
            message.setText(context.getResources().getStringArray(R.array.messages)[position]);

            switch (position % 2) {
                case 0:
                    avatar.setImageResource(R.drawable.ic_account_outline);
                    break;
                case 1:
                    avatar.setImageResource(R.drawable.ic_account_filled);
                    break;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(context.getResources().getStringArray(R.array.names)[position]);
                    }
                }
            });

        }
    }
}
