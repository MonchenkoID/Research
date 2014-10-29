package com.github.monchenkoid.research.loaders;

import java.util.ArrayList;

/**
 * Created by Irina Monchenko on 29.10.2014.
 */
public class DataHandler {

    ArrayList<String> mListStrings = new ArrayList<String>();

    public void setData(ArrayList<String> temp) {
        mListStrings = temp;
    }

    public ArrayList<String> getData() {
        return mListStrings;
    }
}