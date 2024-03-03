package com.hrithik.Service.StateService;

import com.hrithik.DataObject.StatesDO;
import com.hrithik.Repository.StateRepo.StateRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {
    private final String FILE_PATH = "C:\\Users\\hrith\\OneDrive\\Desktop\\stateDistrictMaster.xlsx";
    @Autowired
    StateRepository stateRepository;

    public List<StatesDO> saveState() throws Exception
    {
        List<StatesDO> states = new ArrayList<>();
        StateService stateService = new StateService();
        Sheet sheet = stateService.getSheet(FILE_PATH);
        for (int i = 0; i < 35; i++) {
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(i);
            String stateValue = cell.getStringCellValue();
            StatesDO statesDO = new StatesDO();
            statesDO.setStateCd(stateValue.toUpperCase());
            statesDO.setState(stateValue);
            statesDO.setStateId("INDIA_"+i);
            stateRepository.save(statesDO);
            states.add(statesDO);
        }
        return states;
    }



    public Sheet getSheet(String filePath) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet;
        sheet = workbook.getSheetAt(0);
        return sheet;
    }

    public String getState(Long id) {
        String stateName = String.valueOf(stateRepository.findById(id));
        return stateName;
    }
}
