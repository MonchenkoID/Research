package com.github.monchenkoid.research.processing;

import com.github.monchenkoid.research.bo.User;

import org.json.JSONObject;

/**
 * Created by shiza on 29.10.2014.
 */
public class UserArrayProcessor extends WrapperArrayProcessor<User> {

    @Override
    protected User createObject(JSONObject jsonObject) {
        return new User(jsonObject);
    }

}
