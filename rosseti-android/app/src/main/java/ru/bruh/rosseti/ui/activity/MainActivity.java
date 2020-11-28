package ru.bruh.rosseti.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.ui.fragment.AddFragment;
import ru.bruh.rosseti.ui.fragment.MainFragment;
import ru.bruh.rosseti.ui.fragment.MessagesFragment;
import ru.bruh.rosseti.ui.fragment.MyStatementsFragment;
import ru.bruh.rosseti.ui.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = MainFragment.newInstance();
                    break;
                case R.id.navigation_messages:
                    fragment = MessagesFragment.newInstance();
                    break;
                case R.id.navigation_add:
                    fragment = AddFragment.newInstance();
                    break;
                case R.id.navigation_my_statements:
                    fragment = MyStatementsFragment.newInstance();
                    break;
                case R.id.navigation_profile:
                    fragment = ProfileFragment.newInstance();
                    break;
                default:
                    fragment = new MainFragment();
            }

            setFragment(fragment, false);
            return true;
        });

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, MainFragment.newInstance()).commit();

    }


    public void setFragment(Fragment fragment, boolean isAddToBackStack) {
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment);
        if (isAddToBackStack)
            fr.addToBackStack(null);
        fr.commit();
    }

    public void setBottomNavigationViewVisibility(boolean isVisible) {
        if (isVisible) {
            bottomNavigationView.setVisibility(View.VISIBLE);
        } else {
            bottomNavigationView.setVisibility(View.GONE);
        }
    }
}