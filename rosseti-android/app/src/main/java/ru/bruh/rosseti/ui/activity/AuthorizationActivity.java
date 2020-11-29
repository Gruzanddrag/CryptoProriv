package ru.bruh.rosseti.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.bruh.rosseti.R;

public class AuthorizationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_authorization);

        final Button button = findViewById(R.id.btnAuth);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(AuthorizationActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}




