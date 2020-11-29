package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.CreateStatementRequest;
import ru.bruh.rosseti.model.StatementModel;
import ru.bruh.rosseti.ui.activity.MainActivity;
import ru.bruh.rosseti.ui.app.App;

public class AddFragment extends Fragment {

    private TextInputEditText title;
    private TextInputEditText description;
    private TextInputEditText economicEffect;
    private TextInputEditText positive;
    private TextInputEditText negative;
    private TextInputEditText newness;
    private TextInputEditText expenses;
    private SwitchMaterial agree;

    private TextView send;

    private TextWatcher textWatcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        economicEffect = view.findViewById(R.id.economic_effect);
        positive = view.findViewById(R.id.positive);
        negative = view.findViewById(R.id.negative);
        newness = view.findViewById(R.id.newness);
        expenses = view.findViewById(R.id.limits);
        agree = view.findViewById(R.id.agree);

        send = view.findViewById(R.id.send);
        send.setOnClickListener(view1 -> createRequest());

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changeSendEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        title.addTextChangedListener(textWatcher);
        description.addTextChangedListener(textWatcher);
        economicEffect.addTextChangedListener(textWatcher);
        positive.addTextChangedListener(textWatcher);
        negative.addTextChangedListener(textWatcher);
        newness.addTextChangedListener(textWatcher);
        expenses.addTextChangedListener(textWatcher);
        agree.setOnCheckedChangeListener((compoundButton, b) -> changeSendEnabled());


        return view;
    }

    private void changeSendEnabled() {
        send.setEnabled(
                title.getText().length() != 0
                        && description.getText().length() != 0
                        && economicEffect.getText().length() != 0
                        && positive.getText().length() != 0
                        && negative.getText().length() != 0
                        && newness.getText().length() != 0
                        && expenses.getText().length() != 0
                        && agree.isChecked()
        );
    }

    private void clearFields(){
        title.setText("");
        description.setText("");
        economicEffect.setText("");
        positive.setText("");
        negative.setText("");
        newness.setText("");
        expenses.setText("");
        agree.setChecked(false);
    }


    private void createRequest() {
        CreateStatementRequest request = new CreateStatementRequest();
        request.name = title.getText().toString();
        request.projectDescription = description.getText().toString();
        request.economicEffect = economicEffect.getText().toString();
        request.generatingSaving = agree.isChecked();
        request.newness = newness.getText().toString();
        request.limitationsDescription = expenses.getText().toString();
        request.disadvantageDescription = negative.getText().toString();
        request.advantagesDescription = positive.getText().toString();
        App.api.createStatement(request).enqueue(new Callback<StatementModel>() {
            @Override
            public void onResponse(Call<StatementModel> call, Response<StatementModel> response) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Заявка успешно сохранена")
                        .setPositiveButton("Ок", (dialogInterface, i) -> dialogInterface.dismiss())
                        .show();
                clearFields();
            }

            @Override
            public void onFailure(Call<StatementModel> call, Throwable t) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Ошибка создания заявки")
                        .setPositiveButton("Ок", (dialogInterface, i) -> dialogInterface.dismiss())
                        .show();
                clearFields();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).setBottomNavigationViewVisibility(true);
    }

    public static AddFragment newInstance() {
        return new AddFragment();
    }
}