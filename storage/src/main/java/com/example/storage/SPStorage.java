package com.example.storage;

import android.content.SharedPreferences;

import com.example.common.app.BaseApplication;
import com.example.common.utils.LogUtils;

public class SPStorage implements IStorage{
    private final String TAG=SPStorage.class.getSimpleName();
    @Override
    public <T> boolean save(String key, T value) {
        try {
            MySPutils.put(BaseApplication.getAppContext(),key,value);
        }
        catch (Exception ex){
            LogUtils.INSTANCE.e(TAG,ex);
            return false;
        }

        return true;
    }

    @Override
    public <T> T get(String key) {
        T result = (T) MySPutils.get(BaseApplication.getAppContext(), key, "");
        return result;
    }
}
