package com.cheese.haircutconnect.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.cheese.haircutconnect.R;
import com.cheese.haircutconnect.base.BaseApplication;
import com.cheese.haircutconnect.base.BaseImmersiveAppCompatActivity;
import com.cheese.haircutconnect.tools.ImmersiveTools;
import com.google.gson.Gson;

import butterknife.BindView;

public class MainActivity extends BaseImmersiveAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private AMap aMap;

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

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        ImmersiveTools.setStatusBarColor(getWindow(), getResources().getColor(R.color.colorPrimary));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
                    Log.e("[LOC-ERROR]", new Gson().toJson(amapLocation));
                    return;
                }

                LatLng selfLoc = new LatLng(amapLocation.getLatitude(),amapLocation.getLongitude());
                aMap.moveCamera(CameraUpdateFactory.changeLatLng(selfLoc));
                aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
            }
        };
        BaseApplication.getInstances().getLocClient().setLocationListener(mAMapLocationListener);
        BaseApplication.getInstances().getLocClient().startLocation();
    }


    /**=======================================
     * ------------Default Method-------------
     * =======================================
     */
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


    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
        }
        else if (id == R.id.nav_gallery)
        {

        }
        else if (id == R.id.nav_slideshow)
        {

        }
        else if (id == R.id.nav_manage)
        {

        }
        else if (id == R.id.nav_share)
        {

        }
        else if (id == R.id.nav_send)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
