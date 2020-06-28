package com.example.lib_net.common;

import com.example.lib_net.BuildConfig;

public class Config {

    public final static String AUTH_CODE = "191361171371291c11c11291a41151a01e417f14e1801741";

    //网络请求超时时长
    public final static int TIMEOUT = 10;

    //基础网络地址
    public final static String URL = BuildConfig.baseUrl;

    //测试业务服务器地址
    public final static String TEST_SERVER_URL=BuildConfig.testServerUrl;

    public final static String  NewUrlHeaderKey="newUrl";
    public final static String NewUrlHeaderValue="testServerUrl";
}
