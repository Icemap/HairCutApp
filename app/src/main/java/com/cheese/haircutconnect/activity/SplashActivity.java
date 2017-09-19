package com.cheese.haircutconnect.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cheese.haircutconnect.R;
import com.cheese.haircutconnect.base.BaseImmersiveActivity;

public class SplashActivity extends BaseImmersiveActivity
{
    @Override
    protected int initLayoutId()
    {
        return R.layout.activity_splash;
    }

    @Override
    protected void onInitLogic(Bundle savedInstanceState)
    {
        super.onInitLogic(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //login
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();

                overridePendingTransition(R.anim.fade, R.anim.hold);
            }
        }, 2000);
    }
}
