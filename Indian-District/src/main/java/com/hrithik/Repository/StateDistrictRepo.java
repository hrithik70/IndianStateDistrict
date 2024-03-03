package com.hrithik.Repository;

import com.hrithik.DataObject.StateDistrict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDistrictRepo extends CrudRepository<StateDistrict,Long> {

    public List<StateDistrict> findByState(String state);
}
