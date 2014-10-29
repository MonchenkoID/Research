package com.github.monchenkoid.research.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.github.monchenkoid.research.R;
import com.github.monchenkoid.research.utils.AuthUtils;

/**
 * Created by shiza on 08.10.2014.
 */
public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onLoginClick(View view) {
        AuthUtils.setLogged(true);
        setResult(RESULT_OK);
        finish();
    }

    public void onCancelClick(View view) {
        startActivity(new Intent(this, AsyncTaskLoaderActivity.class));
        finish();
    }
}