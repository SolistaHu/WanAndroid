package com.solista.wanandroid.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.solista.wanandroid.common.utils.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Solista on 2018/10/10.
 */
public abstract class BaseActivity extends SupportActivity {
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        ActivityCollector.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    public abstract int getLayoutId();
}
