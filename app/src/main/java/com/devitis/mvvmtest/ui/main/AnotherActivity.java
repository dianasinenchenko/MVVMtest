package com.devitis.mvvmtest.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.devitis.mvvmtest.R;
import com.devitis.mvvmtest.viewmodel.Response;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

public class AnotherActivity extends AppCompatActivity {

    @Inject
    AnotherViewModelFactory viewModelFactory;

    @BindView(R.id.data_textview)
    TextView dataTV;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private AnotherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(AnotherViewModel.class);
        viewModel.response().observe(this, response -> processResponse(response));
    }

    private void renderLoadingState() {

        dataTV.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

    }

    private void renderDataState(String data) {

        progressBar.setVisibility(View.GONE);
        dataTV.setVisibility(View.VISIBLE);
        dataTV.setText(data);
    }

    private void renderErrorState(Throwable throwable) {

        Timber.e(throwable);
        progressBar.setVisibility(View.GONE);
        dataTV.setVisibility(View.GONE);
        Toast.makeText(this, " Unable to load data", Toast.LENGTH_SHORT).show();
    }

    private void processResponse(Response response) {

        switch (response.status) {

            case LOADING:
                renderLoadingState();
                break;

            case ERROR:
                renderErrorState(response.throwable);
                break;

            case SUCCESS:
                renderDataState(response.data);
                break;
        }

    }

    @OnClick(R.id.data_button)
    void onDataButtonClicked() {

        viewModel.setLoadDataInteractor();
    }

    @OnClick(R.id.another_data_button)
    void onAnotherDataButtonClicked() {

        viewModel.setLoadAnotherDataInteractor();
    }

}
