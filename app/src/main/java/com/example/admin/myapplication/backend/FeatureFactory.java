package com.example.admin.myapplication.backend;

import com.example.admin.myapplication.backend.feature.InformationFeature;

/**
 * Created by admin on 05/11/17.
 */

public class FeatureFactory {
    private static FeatureFactory instance;
    private ServiceFactory serviceFactory;
    private InformationFeature informationFeature;

    private FeatureFactory(ServiceFactory serviceFactory){
        this.serviceFactory = serviceFactory;
    }

    public static FeatureFactory getInstance(ServiceFactory serviceFactory) {
        if (null == instance)
            instance = new FeatureFactory(serviceFactory);
        return instance;
    }

    public InformationFeature getInformationFeature(){
        if(null == informationFeature)
            informationFeature = new InformationFeature(serviceFactory.getInformationService());
        return informationFeature;
    }
}
