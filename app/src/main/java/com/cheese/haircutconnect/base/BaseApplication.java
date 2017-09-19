package com.cheese.haircutconnect.base;

import android.app.Application;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;

/**
 * Created by Wqz on 2016/12/23.
 */

public class BaseApplication extends Application
{
    public static BaseApplication instances;
    private AMapLocationClient mLocationClient;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instances = this;
        initLoc();
    }

    public static BaseApplication getInstances()
    {
        return instances;
    }

    public void initLoc()
    {
        mLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationClient.setLocationOption(mLocationOption);
    }

    public AMapLocationClient getLocClient()
    {
        return mLocationClient;
    }

    public void setLocOption(AMapLocationClientOption option)
    {
        mLocationClient.setLocationOption(option);
    }
}
