package com.github.monchenkoid.research.bo;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/**
 * Created by shiza on 29.10.2014.
 */
public class Note extends JSONObjectWrapper {

    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String ID = "id";

    public static final Parcelable.Creator<Note> CREATOR
            = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public Note(String jsonObject) {
        super(jsonObject);
    }

    public Note(JSONObject jsonObject) {
        super(jsonObject);
    }

    protected Note(Parcel in) {
        super(in);
    }

    public String getTitle() {
        return getString(TITLE);
    }

    public String getContent() {
        return getString(CONTENT);
    }

    public Long getId() {
        return getLong(ID);
    }

}
