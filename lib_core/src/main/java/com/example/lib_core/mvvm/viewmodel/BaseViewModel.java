package com.example.lib_core.mvvm.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.lib_core.mvvm.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class BaseViewModel extends ViewModel implements LifecycleObserver {

    protected Map<String, Repository> repositoryMap;

    public BaseViewModel(){
        repositoryMap = new HashMap<>();
    }

    //注册数据仓库
    //key 数据仓库标识  value数据仓库实例
    protected void registerRepository(String key,Repository repositoryValue){
        if (repositoryMap.containsKey(key)){
            return;
        }
        repositoryMap.put(key, repositoryValue);
    }

    //注销数据仓库
    protected void unregisterRepository(String key,Repository repositoryValue){
        if (repositoryMap.containsKey(key)){
            repositoryMap.remove(key);
        }
    }

    //根据key 获取具体的数据仓库
    //SubRepository 具体的数据仓库
    protected <SubRepository> SubRepository getRepository(String key){
        if (repositoryMap.containsKey(key)){
            return (SubRepository)repositoryMap.get(key);
        }
        return null;
    }

    //lifecycleObserver
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnectOwner(){
        repositoryMap.clear();

        repositoryMap = null;
    }
}