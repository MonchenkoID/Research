package com.github.monchenkoid.research.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.monchenkoid.research.R;
import com.github.monchenkoid.research.ui.ResultActivity;

/**
 * Created by shiza on 08.10.2014.
 */
public class SearchActivity extends Activity implements View.OnClickListener {

    TextView tvName;
    Button btnName;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tvName = (TextView) findViewById(R.id.tvName);
        btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        tvName.setText("Result : " + name);
    }
}