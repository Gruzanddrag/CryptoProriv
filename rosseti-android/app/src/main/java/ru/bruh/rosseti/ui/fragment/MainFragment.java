package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.StatementModel;
import ru.bruh.rosseti.ui.activity.MainActivity;
import ru.bruh.rosseti.ui.app.App;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private MaterialSearchBar searchBar;

    private final MyStatementsAdapter adapter = new MyStatementsAdapter();

    private List<StatementModel> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        searchBar = view.findViewById(R.id.searchBar);


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

        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<StatementModel> list = new ArrayList<>();

                for (StatementModel item : items) {
                    if (item.name.contains(charSequence) || item.author.fIO.contains(charSequence))
                        list.add(item);
                }

                adapter.setData(list);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        App.api.getStatements().enqueue(new Callback<List<StatementModel>>() {
            @Override
            public void onResponse(Call<List<StatementModel>> call, Response<List<StatementModel>> response) {
                items = response.body();
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<StatementModel>> call, Throwable t) {
                new AlertDialog.Builder(Objects.requireNonNull(getContext())).setMessage(t.getMessage()).show();
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).setBottomNavigationViewVisibility(true);
    }


    public static MainFragment newInstance() {
        return new MainFragment();
    }

}