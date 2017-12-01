package com.example.admin.myapplication;

import com.example.admin.myapplication.backend.FeatureFactory;
import com.example.admin.myapplication.backend.ServiceFactory;

/**
 * Created by admin on 05/11/17.
 */

public class Application extends android.app.Application{
    private static FeatureFactory featureFactory;
    private static ServiceFactory serviceFactory;

    public static FeatureFactory getFeatureFactory(){
        return featureFactory;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        serviceFactory = new ServiceFactory(this);
        featureFactory = FeatureFactory.getInstance(serviceFactory);
    }
}
