package com.github.monchenkoid.research;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by shiza on 08.10.2014.
 */
public class SampleActivity extends ActionBarActivity {
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }
    public void onReturnHomeClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onStartSampleClick(View view) {
        startActivity(new Intent(this, SampleActivity.class));
        Toast.makeText(this, "Count = " + ++cnt, Toast.LENGTH_SHORT).show();
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", cnt);

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cnt = savedInstanceState.getInt("count");

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}