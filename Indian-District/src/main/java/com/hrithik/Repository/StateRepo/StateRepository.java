package com.hrithik.Repository.StateRepo;

import com.hrithik.DataObject.StatesDO;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<StatesDO,Long> {
}
