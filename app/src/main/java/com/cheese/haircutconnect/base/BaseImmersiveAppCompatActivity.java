package com.cheese.haircutconnect.base;

import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/9/20 0020.
 */

public abstract class BaseImmersiveAppCompatActivity extends BaseAppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState);
    }
}
