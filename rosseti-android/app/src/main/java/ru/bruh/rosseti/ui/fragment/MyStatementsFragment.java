package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.StatementModel;
import ru.bruh.rosseti.ui.activity.MainActivity;
import ru.bruh.rosseti.ui.app.App;

public class MyStatementsFragment extends Fragment {

    private RecyclerView recyclerView;

    private final MyStatementsAdapter adapter = new MyStatementsAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_statements, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setListener(new MyStatementsAdapter.EventListener() {
            @Override
            public void onCommentClick(StatementModel model) {
                ((MainActivity) getActivity()).setFragment(CommentsFragment.newInstance(), true);
            }

            @Override
            public void onFavouriteClick(StatementModel model) {

            }

            @Override
            public void onMessageClick(StatementModel model) {
                ((MainActivity) getActivity()).setFragment(MessageFragment.newInstance(), true);
            }

            @Override
            public void onItemClick(StatementModel model) {
                ((MainActivity) getActivity()).setFragment(StatementFragment.newInstance(model), true);

            }
        });

        App.api.getStatements().enqueue(new Callback<List<StatementModel>>() {
            @Override
            public void onResponse(Call<List<StatementModel>> call, Response<List<StatementModel>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<StatementModel>> call, Throwable t) {
                new AlertDialog.Builder(getContext()).setMessage(t.getMessage()).show();
            }
        });

        return view;
    }

    public static MyStatementsFragment newInstance() {
        return new MyStatementsFragment();
    }
}