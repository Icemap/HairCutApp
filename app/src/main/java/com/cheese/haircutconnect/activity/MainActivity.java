package com.cheese.haircutconnect.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.cheese.haircutconnect.R;
import com.cheese.haircutconnect.base.BaseActivity;
import com.cheese.haircutconnect.base.BaseApplication;

import butterknife.BindView;

public class MainActivity extends BaseActivity
{
    AMap aMap;

    @BindView(R.id.main_map_view)
    MapView mMapView;

    @Override
    protected int initLayoutId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitLogic(Bundle savedInstanceState)
    {
        super.onInitLogic(savedInstanceState);
        mMapView.onCreate(savedInstanceState);

        if (aMap == null)
            aMap = mMapView.getMap();

        locSelf();
    }



    public void locSelf()
    {
        AMapLocationListener mAMapLocationListener = new AMapLocationListener()
        {
            @Override
            public void onLocationChanged(AMapLocation amapLocation)
            {
                if(amapLocation.getErrorCode() != 0)
                {
                    Toast.makeText(MainActivity.this, "定位失败", Toast.LENGTH_LONG).show();
                    return;
                }

                LatLng selfLoc = new LatLng(amapLocation.getLatitude(),amapLocation.getLongitude());
                aMap.moveCamera(CameraUpdateFactory.changeLatLng(selfLoc));
                aMap.moveCamera(CameraUpdateFactory.zoomTo(12));
            }
        };
        BaseApplication.getInstances().getLocClient().setLocationListener(mAMapLocationListener);
        BaseApplication.getInstances().getLocClient().startLocation();
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }
}
