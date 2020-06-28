package com.example.lib_net.retrofit.calladapter;

import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lib_net.procotol.BaseRespEntity;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAadapter<R> implements CallAdapter<R, LiveData<BaseRespEntity<R>>> {

    Type type;

    public LiveDataCallAadapter(Type _t){
        type = _t;
    }

    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public LiveData<BaseRespEntity<R>> adapt(Call<R> call) {

        final MutableLiveData<BaseRespEntity<R>> data = new MutableLiveData<>();

        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()){
                    data.setValue((BaseRespEntity<R>) response.body());
                }else {
                    data.postValue((BaseRespEntity<R>) response.body());
                }
            }

            @Override
            public void onFailure(Call<R> call, Throwable t) {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()){
                    data.setValue(null);
                }else {
                    data.postValue(null);
                }
            }
        });
        return data;
    }
}