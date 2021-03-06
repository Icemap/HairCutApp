package com.cheese.haircutconnect.base;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by Wqz on 2016/12/23.
 */

abstract public class BaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        ButterKnife.bind(this);
        onInitLogic(savedInstanceState);
    }

    protected abstract int initLayoutId();
    protected void onInitLogic(Bundle savedInstanceState) {}

    protected BaseApplication getBaseApplication()
    {
        return ((BaseApplication) getApplication());
    }
}
