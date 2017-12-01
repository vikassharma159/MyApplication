package com.example.admin.myapplication.backend.feature;

import com.example.admin.myapplication.backend.service.InformationService;
import com.example.admin.myapplication.model.Information;

import java.util.List;

/**
 * Created by admin on 05/11/17.
 */

public class InformationFeature {
    private InformationService informationService;

    public InformationFeature(InformationService informationService){
        this.informationService = informationService;
    }

    public void addPersonInformation(Information information){
        informationService.addPersonInformation(information);
    }

    public List<Information> getPersonInformationList(){
        return informationService.getPersonInformationList();
    }
}
