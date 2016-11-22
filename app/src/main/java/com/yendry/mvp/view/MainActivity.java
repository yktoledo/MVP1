package com.yendry.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yendry.mvp.R;
import com.yendry.mvp.presenter.MainMvpPresenter;
import com.yendry.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    ProgressBar progressBar;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        progressBar = (ProgressBar) findViewById(R.id.prsBar);
        textView = (TextView) findViewById(R.id.txt);
        button = (Button) findViewById(R.id.btn);
    }


    public void doMagic(){

    }
    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainPresenter != null)
            mainPresenter.detachView();
    }
}
