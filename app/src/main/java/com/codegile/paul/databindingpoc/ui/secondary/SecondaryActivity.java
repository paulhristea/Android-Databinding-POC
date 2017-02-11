package com.codegile.paul.databindingpoc.ui.secondary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codegile.paul.databindingpoc.R;
import com.codegile.paul.databindingpoc.databinding.SecondaryActivityBinding;
import com.codegile.paul.databindingpoc.ui.tertiary.TertiaryActivity;

/**
 * Created by Paul on 10-Feb-17.
 */

public class SecondaryActivity extends AppCompatActivity implements SecondaryContract.View {

    private SecondaryContract.Presenter mPresenter;
    private SecondaryViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.secondary_activity);

        this.mPresenter = new SecondaryPresenter(this);
        this.mViewModel = new SecondaryViewModel();
        SecondaryActivityBinding binding = SecondaryActivityBinding
                .inflate(LayoutInflater.from(this), (ViewGroup) findViewById(android.R.id.content), true);
        binding.setActionHandler(mPresenter);
        binding.setVm(mViewModel);
    }

    @Override
    public void toastAndClearText() {
        Toast.makeText(this, "The text was: " + mViewModel.getText(), Toast.LENGTH_LONG).show();
        mViewModel.setText("");
    }

    @Override
    public void startTertiaryActivity() {
        startActivity(new Intent(SecondaryActivity.this, TertiaryActivity.class));
    }
}
