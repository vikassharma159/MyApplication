package com.example.admin.myapplication.backend.presenter;

import com.example.admin.myapplication.Application;
import com.example.admin.myapplication.backend.feature.InformationFeature;
import com.example.admin.myapplication.model.Information;

import java.util.List;

/**
 * Created by admin on 05/11/17.
 */

public class InformationPresenter {
    private InformationFeature informationFeature;

    public InformationPresenter(){
        this.informationFeature = Application.getFeatureFactory().getInformationFeature();
    }

    public void addPersonInformation(Information information){
        informationFeature.addPersonInformation(information);
    }

    public List<Information> getPersonInformationList(){
        return informationFeature.getPersonInformationList();
    }
}
