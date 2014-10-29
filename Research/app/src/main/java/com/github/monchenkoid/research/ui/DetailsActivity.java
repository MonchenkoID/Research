package com.github.monchenkoid.research.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.github.monchenkoid.research.R;
import com.github.monchenkoid.research.bo.NoteGsonModel;


public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        NoteGsonModel noteGsonModel = (NoteGsonModel) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(android.R.id.text1)).setText(noteGsonModel.getTitle());
        ((TextView) findViewById(android.R.id.text2)).setText(noteGsonModel.getContent());
    }

}
