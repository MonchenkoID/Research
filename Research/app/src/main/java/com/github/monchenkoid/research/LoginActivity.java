package com.github.monchenkoid.research;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.monchenkoid.research.utils.AuthUtils;

/**
 * Created by shiza on 08.10.2014.
 */
public class LoginActivity extends ActionBarActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        editText = (EditText) findViewById(R.id.edit_text);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

       // outState.putString("result", edit_text.getText().toString());

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setText("lol");
        //savedInstanceState.getString("result"));

    }

    public void onLoginClick(View view) {
        AuthUtils.setLogged(true);
        setResult(RESULT_OK);
        finish();
    }

}