package com.hg.danmoxiang_rrmvp.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.integration.AppManager;
import com.hg.danmoxiang_rrmvp.retrofit.ApiClient;
import com.hg.danmoxiang_rrmvp.retrofit.ApiStores;
import com.hg.danmoxiang_rrmvp.utils.Utils;
import com.jaeger.library.StatusBarUtil;
import com.wuxiaolong.androidutils.library.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;


public abstract class BaseActivity extends AppCompatActivity {
    public Activity mActivity;
    private CompositeDisposable mCompositeDisposable;
    private List<Call> calls;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        mActivity = this;
        StatusBarUtil.setTranslucent(this,150);
        ButterKnife.bind(this);
        AppManager.getAppManager().setCurrentActivity(mActivity);
    }


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mActivity = this;
        StatusBarUtil.setTranslucent(this,150);
        ButterKnife.bind(this);
        AppManager.getAppManager().setCurrentActivity(mActivity);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        mActivity = this;
        StatusBarUtil.setTranslucent(this,150);
        ButterKnife.bind(this);
        AppManager.getAppManager().setCurrentActivity(mActivity);
    }


    @Override
    protected void onDestroy() {
        callCancel();
        onUnsubscribe();
        super.onDestroy();
    }

    public ApiStores apiStores() {
        return ApiClient.retrofit().create(ApiStores.class);
    }

    public void addCalls(Call call) {
        if (calls == null) {
            calls = new ArrayList<>();
        }
        calls.add(call);
    }

    private void callCancel() {
        if (calls != null && calls.size() > 0) {
            for (Call call : calls) {
                if (!call.isCanceled())
                    call.cancel();
            }
            calls.clear();
        }
    }


    public <T> void addSubscription(Observable<T> observable, DisposableObserver<T> observer) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(observer);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void addSubscription(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public void onUnsubscribe() {
        LogUtil.d("onUnSubscribe");
        //取消注册，以避免内存泄露
        if (mCompositeDisposable != null)
            mCompositeDisposable.dispose();
    }

    public Toolbar initToolBar(String title) {

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            TextView toolbaTitle = toolbar.findViewById(R.id.toolbar_title);
            toolbaTitle.setText(title);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        if (findViewById(R.id.toolbar_back) != null) {
            findViewById(R.id.toolbar_back).setOnClickListener(v -> {
                mActivity.onBackPressed();
            });
        }
        return toolbar;
    }

    public Toolbar initToolBarAsHome(String title) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            TextView toolbaTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
            toolbaTitle.setText(title);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        if (findViewById(R.id.toolbar_back) != null) {
            findViewById(R.id.toolbar_back).setOnClickListener(v -> {
                mActivity.onBackPressed();
            });
        }
        return toolbar;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();//返回
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void toastShow(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        if (progressDialog == null)
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }


    public void launchActivity(@NonNull Intent intent) {
        Utils.startActivity(intent);
    }

    public void killMyself() {
        finish();
    }



}
