package ru.bruh.rosseti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AuthorizationFragment extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_authorization);

    }

    public void click(View view) {
        Intent intent = new Intent(AuthorizationFragment.this, MainActivity.class);
        startActivity(intent);
    }

    }
