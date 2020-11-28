package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.Objects;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.StatementModel;
import ru.bruh.rosseti.ui.activity.MainActivity;

public class StatementFragment extends Fragment {

    private static final String MODEL = "MODEL";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statement, container, false);



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).setBottomNavigationViewVisibility(false);
    }

    public static StatementFragment newInstance(StatementModel model) {
        StatementFragment fragment = new StatementFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MODEL, model);
        fragment.setArguments(bundle);
        return fragment;
    }
}