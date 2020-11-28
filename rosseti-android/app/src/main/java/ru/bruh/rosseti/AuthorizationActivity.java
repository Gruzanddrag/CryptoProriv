package ru.bruh.rosseti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.bruh.rosseti.ui.activity.MainActivity;

public class AuthorizationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_authorization);

        final Button button = findViewById(R.id.btnAuth);

        button.setOnClickListener (new View.OnClickListener(){
            public void onClick (View v) {

                Intent intent = new Intent(AuthorizationActivity.this, MainActivity.class);
                startActivity(intent);
                String applicationName  = getString(R.string.to_come_in);
            }
    });
    }
    }




