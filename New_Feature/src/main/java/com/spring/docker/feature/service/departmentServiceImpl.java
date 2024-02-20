package com.spring.docker.feature.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.docker.feature.dao.DepartmentRepository;
import com.spring.docker.feature.entity.Department;
import com.spring.docker.feature.error.DepartmentNotFoundException;


@Service
public class departmentServiceImpl implements departmentService {
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department saveDepartment(Department department) {
		
		return repo.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public  Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
     Optional<Department> department= repo.findById(departmentId);
     if(!department.isPresent()) {
    	 throw new DepartmentNotFoundException("Department Not Found");
     }
     return department.get();
		}

	@Override
	public void deleteById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department= repo.findById(departmentId);
	     if(!department.isPresent()) {
	    	 throw new DepartmentNotFoundException("Department Not Found");
	     }
		repo.deleteById(departmentId);
	}

	

	@Override
	public Department updateById(Long departmentId, Department department) {
		Department depDb= repo.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
		depDb.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
			depDb.setDepartmentCode(department.getDepartmentCode());
			}
		if(Objects.nonNull(department.getDepartmentBranch()) && !"".equalsIgnoreCase(department.getDepartmentBranch())){
			depDb.setDepartmentBranch(department.getDepartmentBranch());
			}
	
	 return repo.save(depDb);
	}

	@Override
	public Department getByDepartmentName(String departmentName) {
		
	    return repo.findByDepartmentNameIgnoreCaseJPQL(departmentName);
	}

	

}

