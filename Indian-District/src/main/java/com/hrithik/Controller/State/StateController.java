package com.hrithik.Controller.State;

import com.hrithik.DataObject.StatesDO;
import com.hrithik.Service.StateService.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    @Autowired
    StateService stateService;
    @GetMapping("saveState")
    public List<StatesDO> saveState() throws Exception
    {
        return stateService.saveState();
    }

    @PostMapping("state/{id}")
    public String getState(@PathVariable Long id)
    {
        String name = stateService.getState(id);
        return name;
    }

}
