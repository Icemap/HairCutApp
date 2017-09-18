package com.cheese.haircutconnect.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public abstract class BaseFragment extends Fragment
{

    protected abstract int initLayoutId();
    protected void onInitLogic() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View thisView = inflater.inflate(initLayoutId(), container, false);
        ButterKnife.bind(this, thisView);
        onInitLogic();
        return thisView;
    }
}
