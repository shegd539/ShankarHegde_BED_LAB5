package com.greatlearning.bed.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.bed.assesment.databasemodel.EmployeeModel;
@Repository
public interface UpdateEmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	
	@Transactional
	@Modifying
	@Query(value="update EMPLOYEE_RECORDS u set u.first_name = :firstname, u.last_name = :lastname, u.email = :email where u.id = :id", nativeQuery = true)
	void updateEmployeeRecord(@Param("firstname")String firstname, @Param("lastname")String lastname,@Param("email")String email,@Param("id")long id);


}
