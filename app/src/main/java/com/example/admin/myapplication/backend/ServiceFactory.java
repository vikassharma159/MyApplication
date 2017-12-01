package com.example.admin.myapplication.backend;

import android.content.Context;

import com.example.admin.myapplication.backend.service.InformationService;

/**
 * Created by admin on 05/11/17.
 */

public class ServiceFactory {
    private final Context context;
    private InformationService informationService;

    public ServiceFactory(Context context){
        this.context = context;
    }

    public InformationService getInformationService(){
        if (null == informationService)
            informationService = new InformationService();
        return informationService;
    }
}
