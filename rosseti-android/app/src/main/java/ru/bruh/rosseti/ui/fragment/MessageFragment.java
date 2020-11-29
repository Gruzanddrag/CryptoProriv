package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.ui.activity.MainActivity;

public class MessageFragment extends Fragment {

    private RecyclerView recyclerView;

    private MessageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        adapter = new MessageAdapter(getContext());

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(view1 -> getParentFragmentManager().popBackStack());

        TextView title = view.findViewById(R.id.toolbar_title);
        title.setText(getArguments().getString(NAME));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).setBottomNavigationViewVisibility(false);
    }

    private static final String NAME = "NAME";

    public static MessageFragment newInstance(String name) {
        MessageFragment fragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(NAME, name);
        fragment.setArguments(bundle);
        return fragment;
    }
}