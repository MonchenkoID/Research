package com.github.monchenkoid.research.callbacks;

import android.util.Log;

import com.github.monchenkoid.research.helper.DataManager;

/**
 * Created by shiza on 29.10.2014.
 */
public abstract class SimpleCallback<Result> implements DataManager.Callback {

    @Override
    public void onDataLoadStart() {
        Log.d("SimpleCallback", "onDataLoadStart");
    }

    @Override
    public void onError(Exception e) {
        Log.e("SimpleCallback", "onError", e);
    }

}
