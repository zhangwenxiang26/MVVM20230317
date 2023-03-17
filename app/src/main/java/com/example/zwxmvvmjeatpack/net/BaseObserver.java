package com.example.zwxmvvmjeatpack.net;


import io.reactivex.observers.ResourceObserver;

public abstract class BaseObserver<T> extends ResourceObserver<T> {
    @Override
    protected void onStart() {
        super.onStart();
        //Todo
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        failure(e);
    }


    @Override
    public void onComplete() {
        //Todo
    }

    /**
     * 成功回调
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 失败回调
     * @param e
     */
    public abstract void failure(Throwable e);

}
