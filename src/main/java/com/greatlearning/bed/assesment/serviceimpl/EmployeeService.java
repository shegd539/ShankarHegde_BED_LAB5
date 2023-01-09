package com.greatlearning.bed.assesment.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greatlearning.bed.assesment.databasemodel.EmployeeModel;
import com.greatlearning.bed.assesment.model.Employee;
import com.greatlearning.bed.assesment.repository.EmployeeRepository;
import com.greatlearning.bed.assesment.repository.UpdateEmployeeRepository;

@Component
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	;
	@Autowired
	UpdateEmployeeRepository updateEmployeeRepository;
	
	
	public void saveEmployee(Employee employee) {
		
		EmployeeModel employeeModel=new EmployeeModel();
		employeeModel.setFirstName(employee.getFirstName());
		employeeModel.setLastName(employee.getLastName());
		employeeModel.setEmail(employee.getEmail());
		employeeRepository.save(employeeModel);
		
	}
	
	
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    
    
    public EmployeeModel getEmployeeById(long id) {
        Optional < EmployeeModel > optional = employeeRepository.findById(id);
        EmployeeModel employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
            updateEmployeeRepository.updateEmployeeRecord(optional.get().getFirstName(), optional.get().getLastName(), optional.get().getEmail(), id);
            System.out.println("Records updated ");
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    
    
    
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    
    
    public void updateEmployeeById(Employee employee) {
    	updateEmployeeRepository.updateEmployeeRecord(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getId());
    }
    
    
    
}
