package com.cheese.haircutconnect.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by cheese on 17-9-20.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity
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
