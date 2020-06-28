package com.example.lib_core.mvvm.repository;

import com.example.lib_core.mvvm.model.IModel;

//数据仓库的类
public abstract class Repository<T extends IModel> {

    //业务 model
    protected T mModel;

    public Repository(){
        mModel = creatModel();
    }

    //创建业务 model
    protected abstract T creatModel();
}