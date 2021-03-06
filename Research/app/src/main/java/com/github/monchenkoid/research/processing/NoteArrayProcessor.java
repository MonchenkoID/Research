package com.github.monchenkoid.research.processing;

import com.github.monchenkoid.research.bo.Note;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiza on 29.10.2014.
 */
public class NoteArrayProcessor implements Processor<List<Note>, InputStream> {

    @Override
    public List<Note> process(InputStream inputStream) throws Exception {
        String string = new StringProcessor().process(inputStream);
        JSONArray array = new JSONArray(string);
        List<Note> noteArray = new ArrayList<Note>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            noteArray.add(new Note(jsonObject));
        }
        return noteArray;
    }

}
