package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.bruh.rosseti.R;

public class MyStatementsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_statements, container, false);
    }

    public static MyStatementsFragment newInstance() {
        return new MyStatementsFragment();
    }
}