package ru.bruh.rosseti.ui.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import ru.bruh.rosseti.R;
import ru.bruh.rosseti.model.StatementModel;
import ru.bruh.rosseti.ui.activity.MainActivity;

public class StatementFragment extends Fragment {

    private static final String MODEL = "MODEL";

    private TextView title;
    private TextView description;
    private TextView economicEffect;
    private TextView author;
    private TextView date;
    private TextView category;
    private TextView status;
    private TextView positive;
    private TextView newness;
    private TextView expenses;
    private TextView period;
    private TextView docs;
    private TextView dop;
    private TextView comments;

    private StatementModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statement, container, false);

        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        economicEffect = view.findViewById(R.id.economic_effect);
        author = view.findViewById(R.id.author);
        date = view.findViewById(R.id.date);
        category = view.findViewById(R.id.category);
        status = view.findViewById(R.id.status);
        positive = view.findViewById(R.id.positive);
        newness = view.findViewById(R.id.newness);
        expenses = view.findViewById(R.id.expenses);
        period = view.findViewById(R.id.period);
        docs = view.findViewById(R.id.docs);
        dop = view.findViewById(R.id.dop);
        comments = view.findViewById(R.id.comments);

        model = ((StatementModel) getArguments().getSerializable(MODEL));

        title.setText(Html.fromHtml(model.name));
        author.setText(model.author.fIO);
        date.setText(new SimpleDateFormat("dd MMM yyyy").format(new Date(model.createdAt * 1000)));
        status.setText(model.status.statusName);
        category.setText(model.category.name);
        description.setText(Html.fromHtml(model.projectDescription));
        economicEffect.setText(Html.fromHtml(model.economicEffect));
        positive.setText(Html.fromHtml(model.advantagesDescription));
        newness.setText(Html.fromHtml(model.newness));


        int statusResId = 0;
        switch (model.status.status) {
            case 0:
                statusResId = R.drawable.grey_dot;
                break;
            case 1:
                statusResId = R.drawable.blue_dot;
                break;
            case 2:
                statusResId = R.drawable.red_dot;
                break;
            case 3:
                statusResId = R.drawable.yellow_dot;
                break;
            case 4:
                statusResId = R.drawable.red_dot;
                break;
            default:
                statusResId = R.drawable.green_dot;
                break;
        }

        status.setCompoundDrawablesWithIntrinsicBounds(statusResId, 0, 0, 0);

       /* positive.setText(Html.fromHtml(model.projectDescription));
        negative.setText(Html.fromHtml(model.projectDescription));
        expenses.setText(Html.fromHtml(model.projectDescription));
        period.setText(Html.fromHtml(model.));*/


/*        docs.setMovementMethod(LinkMovementMethod.getInstance());
        dop.setMovementMethod(LinkMovementMethod.getInstance());*/

        comments.setText("Комментарии: " + new Random().nextInt(250));

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