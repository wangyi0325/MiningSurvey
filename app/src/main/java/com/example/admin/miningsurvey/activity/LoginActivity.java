package com.example.admin.miningsurvey.activity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.miningsurvey.R;
import com.example.admin.miningsurvey.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.et_name)
        EditText et_name;
    @BindView(R.id.et_passworld)
        EditText et_passworld;
    @BindView(R.id.btn_logn)
        Button btn_logn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        btn_logn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_logn:
                openActivity(HomeActivity.class);
                break;
        }


    }

}
