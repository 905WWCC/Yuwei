package com.product.yuwei;

import android.app.Application;

import org.xutils.x;

/**
 * Created by teng on 10/14/16.
 */
public class YuweiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

}
