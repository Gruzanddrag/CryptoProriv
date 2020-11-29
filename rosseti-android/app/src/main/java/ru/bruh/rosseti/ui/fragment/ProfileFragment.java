package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.ProfileModel;
import ru.bruh.rosseti.ui.app.App;

public class ProfileFragment extends Fragment {

    private TextInputEditText fio;
    private TextInputEditText birth;
    private TextInputEditText phone;
    private TextInputEditText company;
    private TextInputEditText department;
    private TextInputEditText position;
    private TextInputEditText experience;
    private TextInputEditText education;
    private TextInputEditText status;
    private TextInputEditText count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        fio = view.findViewById(R.id.fio_edit_text);
        birth = view.findViewById(R.id.birth_edit_text);
        phone = view.findViewById(R.id.phone_edit_text);
        company = view.findViewById(R.id.company_edit_text);
        department = view.findViewById(R.id.department_edit_text);
        position = view.findViewById(R.id.position_edit_text);
        experience = view.findViewById(R.id.experience_edit_text);
        education = view.findViewById(R.id.education_edit_text);
        status = view.findViewById(R.id.game_edit_text);
        count = view.findViewById(R.id.statement_count_edit_text);

        App.api.getProfile().enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                fio.setText(response.body().surname + " " + response.body().name);
                phone.setText(response.body().userProfile.phone);
                department.setText(response.body().userProfile.department);
                position.setText(response.body().userProfile.position);
                experience.setText(response.body().userProfile.experience + "мес.");
                count.setText(response.body().userProfile.rating + "");
                education.setText(response.body().userProfile.userEducation.get(0).university + " " + response.body().userProfile.userEducation.get(0).graduationYear);
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

            }
        });

        return view;
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
}