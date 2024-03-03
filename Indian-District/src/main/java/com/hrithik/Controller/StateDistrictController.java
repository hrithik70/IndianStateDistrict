package com.hrithik.Controller;

import com.hrithik.DataObject.StateDistrict;
import com.hrithik.Service.StateDistrictExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateDistrictController {

    @Autowired
    StateDistrictExecutor stateDistrictExecutor;

    @GetMapping(value = "SaveStateDistrict")
    public List<StateDistrict> SaveStateDistrict() throws Exception
    {
        List<StateDistrict> stateDistrictList;
        stateDistrictList = stateDistrictExecutor.getStateDistrict();
        return stateDistrictList;
    }

    @GetMapping(value = "getAllDistrict")
    public List<StateDistrict> getStateDistrict() throws Exception
    {
        List<StateDistrict> stateDistrictList;
        stateDistrictList = stateDistrictExecutor.getAllStateDistrict();
        return stateDistrictList;
    }

    @PostMapping(value = "State/{name}")
    public List<StateDistrict> getDistrictByState(@PathVariable String name) throws Exception
    {
        List<StateDistrict> stateDistrictList;
        stateDistrictList = stateDistrictExecutor.getDistrictByState(name);
        return stateDistrictList;
    }


}