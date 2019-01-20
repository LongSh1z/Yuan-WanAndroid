package com.example.yuan_wanandroid.base.presenter;

import com.example.yuan_wanandroid.base.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/01/20
 *     desc   :
 * </pre>
 */


public class BasePresenter <T extends BaseView> implements IPresenter<T> {
    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public boolean isAttachView() {
        return mView != null;
    }

    @Override
    public void detachView() {
        mView = null;
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void addRxSubscribe(Disposable disposable) {
        if(mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}