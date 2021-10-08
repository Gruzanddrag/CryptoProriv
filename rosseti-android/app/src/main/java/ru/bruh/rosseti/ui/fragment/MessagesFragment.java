package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.ui.activity.MainActivity;

public class MessagesFragment extends Fragment {

    private RecyclerView recyclerView;

    private MessagesAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        adapter = new MessagesAdapter(getContext());

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setListener(name -> ((MainActivity) Objects.requireNonNull(getActivity())).setFragment(MessageFragment.newInstance(name), true));

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).setBottomNavigationViewVisibility(true);
    }

    public static MessagesFragment newInstance() {
        return new MessagesFragment();
    }
}