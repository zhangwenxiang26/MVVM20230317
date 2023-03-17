package com.example.zwxmvvmjeatpack.net;



import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
public abstract class BaseRetrofit {
    private Retrofit mRetrofit;

    protected BaseRetrofit() {
        initRetrofit();
    }


    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                //设置网络请求的Url地址
                .baseUrl(configBaseUrl())
                //设置数据解析器：使用Gson 解析
                .addConverterFactory(GsonConverterFactory.create())
                // 接收非json字符串
                .addConverterFactory(ScalarsConverterFactory.create())
                //使用Rxjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();

    }

    /**
     * 配置 baseUrl
     *
     * @return
     */
    protected abstract String configBaseUrl();

    private OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

        if (configShowLog()) {
            builder.addInterceptor(new LoggingInterceptor());
        }

        return builder.build();
    }

    /**
     * 显示请求与响应日志
     *
     * @return
     */
    protected abstract boolean configShowLog();


    /**
     * 方法泛型
     *
     * @param service
     * @param <T>
     * @return
     */
    protected <T> T createApi(final Class<T> service) {
        return mRetrofit.create(service);
    }

}
