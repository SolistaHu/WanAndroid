package com.solista.wanandroid.common.presenter;

import com.solista.wanandroid.common.view.IBaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Solista on 2018/10/10.
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;
    private CompositeDisposable compositeDisposable;
    private BaseDataManager mBaseDataManager;

    public BasePresenter(BaseDataManager baseDataManager) {
        this.mBaseDataManager = baseDataManager;
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }

    @Override
    public boolean getNightModeState() {
        return mBaseDataManager.getNightModeState();
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {
        mBaseDataManager.setLoginStatus(loginStatus);
    }

    @Override
    public boolean getLoginStatus() {
        return mBaseDataManager.getLoginStatus();
    }

    @Override
    public String getLoginAccount() {
        return mBaseDataManager.getLoginAccount();
    }

    @Override
    public void setLoginAccount(String account) {
        mBaseDataManager.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mBaseDataManager.setLoginPassword(password);
    }

    @Override
    public int getCurrentPage() {
        return mBaseDataManager.getCurrentPage();
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
