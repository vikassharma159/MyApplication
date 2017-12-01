package com.example.admin.myapplication.backend.service;

import com.example.admin.myapplication.model.Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05/11/17.
 */

public class InformationService {
    private static List<Information> personList;

    public void addPersonInformation(Information information){
        if(null == personList)
            personList = new ArrayList<>();
        personList.add(information);
    }

    public List<Information> getPersonInformationList(){
        return personList;
    }
}
