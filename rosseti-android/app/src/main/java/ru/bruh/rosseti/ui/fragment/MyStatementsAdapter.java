package ru.bruh.rosseti.ui.fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.StatementModel;

public class MyStatementsAdapter extends RecyclerView.Adapter<MyStatementsAdapter.MyStatementViewHolder> {

    private List<StatementModel> items = new ArrayList<>();

    interface EventListener {
        void onCommentClick(StatementModel model);

        void onFavouriteClick(StatementModel model);

        void onMessageClick(StatementModel model);

        void onItemClick(StatementModel model);
    }

    private EventListener listener;

    public void setData(List<StatementModel> list) {
        items = list;
        notifyDataSetChanged();
    }

    public void setListener(EventListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyStatementViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @NonNull
    @Override
    public MyStatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyStatementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_statement, parent, false));
    }

    public class MyStatementViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private TextView author;
        private TextView date;
        private ImageView upvote;
        private TextView rating;
        private TextView category;
        private ImageView message;
        private ImageView favorite;
        private TextView comments;
        private TextView status;


        public MyStatementViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(StatementModel model) {
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            upvote = itemView.findViewById(R.id.upvote);
            rating = itemView.findViewById(R.id.rating);
            category = itemView.findViewById(R.id.category);
            message = itemView.findViewById(R.id.message);
            favorite = itemView.findViewById(R.id.favorite);
            comments = itemView.findViewById(R.id.comments);
            status = itemView.findViewById(R.id.status);

            title.setText(Html.fromHtml(model.name));
            description.setText(Html.fromHtml(model.projectDescription));
            author.setText(model.author.fIO);
            date.setText(new SimpleDateFormat("dd MMM yyyy").format(new Date(model.createdAt * 1000)));
            rating.setText(model.upvotes.toString());
            category.setText(model.category.name);
            comments.setText(Integer.toString(new Random().nextInt(500)));
            status.setText(model.status.statusName);

            int statusResId = 0;
            switch (model.status.status) {
                case 0:
                    statusResId = R.drawable.grey_dot;
                    break;
                case 1:
                    statusResId = R.drawable.blue_dot;
                    break;
                case 2:
                    statusResId = R.drawable.red_dot;
                    break;
                case 3:
                    statusResId = R.drawable.yellow_dot;
                    break;
                case 4:
                    statusResId = R.drawable.red_dot;
                    break;
                default:
                    statusResId = R.drawable.green_dot;
                    break;
            }

            status.setCompoundDrawablesWithIntrinsicBounds(statusResId, 0, 0, 0);

            upvote.setOnClickListener(view -> {
                boolean isSelected = !upvote.isSelected();
                upvote.setSelected(isSelected);
                if (isSelected) {
                    model.upvotes++;
                } else {
                    model.upvotes--;
                }
                rating.setText(model.upvotes.toString());
            });

            favorite.setOnClickListener(view -> {
                boolean isSelected = !favorite.isSelected();
                favorite.setSelected(isSelected);
                if (listener != null)
                    listener.onFavouriteClick(model);
            });

            comments.setOnClickListener(view -> {
                if (listener != null)
                    listener.onCommentClick(model);
            });

            message.setOnClickListener(view -> {
                if (listener != null)
                    listener.onMessageClick(model);
            });

            itemView.setOnClickListener(view -> {
                if (listener != null)
                    listener.onItemClick(model);
            });

        }
    }
}
