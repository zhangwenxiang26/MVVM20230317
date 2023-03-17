package com.example.zwxmvvmjeatpack.net;


import com.example.zwxmvvmjeatpack.api.Api;

public class RetrofitManager extends BaseRetrofit {
    private  static final String DEFAULT_IP_ADDRESS_REMOTE = "https://www.wanandroid.com";
    private RetrofitManager() {
        super();
    }

    private static class RetrofitManagerHolder {
        private static final RetrofitManager mRetrofitManager = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.mRetrofitManager;
    }


    @Override
    protected String configBaseUrl() {
        return DEFAULT_IP_ADDRESS_REMOTE+"/";
    }

    @Override
    protected boolean configShowLog() {
        return true;
    }

    public Api createEBikeApi() {
        return createApi(Api.class);
    }

}
