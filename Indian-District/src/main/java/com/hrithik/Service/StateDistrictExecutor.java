package com.hrithik.Service;

import com.hrithik.DataObject.StateDistrict;
import com.hrithik.Repository.StateDistrictRepo;
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
public class StateDistrictExecutor {

    @Autowired
    StateDistrictRepo stateDistrictRepo;
    private final String FILE_PATH = "C:\\Users\\hrith\\OneDrive\\Desktop\\state.xlsx";
    public List<StateDistrict> getStateDistrict() throws Exception{


        List<String> list = getDistrict();
        int noOfDistrict = list.size();
        String stateName = getStateName();

        List<StateDistrict> stateDistrictList = new ArrayList<>();
        for (int i = 0; i < noOfDistrict; i++) {
            StateDistrict state1 = new StateDistrict();
            state1.setDistrictCd(list.get(i).toUpperCase());
            state1.setDistrict(list.get(i));
            state1.setStateCd(stateName.toUpperCase());
            state1.setState(stateName);
            stateDistrictRepo.save(state1);
            stateDistrictList.add(state1);
        }
        return stateDistrictList;
    }

    public List<String> getDistrict() throws Exception
    {
        List<String> districtList = new ArrayList<>();
        Sheet sheet = getSheet(FILE_PATH);
        for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            districtList.add(cell.getStringCellValue());
        }
        return districtList;
    }

    public String getStateName() throws Exception
    {
        Sheet sheet = getSheet(FILE_PATH);
        Row row = sheet.getRow(0);
        return row.getCell(0).getStringCellValue();
    }

    public Sheet getSheet(String filePath) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet;
        sheet = workbook.getSheetAt(0);
        return sheet;
    }


    public List<StateDistrict> getAllStateDistrict() {
        List<StateDistrict> allDistrict = (List<StateDistrict>)stateDistrictRepo.findAll();
        return allDistrict;
    }

    public List<StateDistrict> getDistrictByState(String name) {
        return (List<StateDistrict>) stateDistrictRepo.findByState(name);
    }
}