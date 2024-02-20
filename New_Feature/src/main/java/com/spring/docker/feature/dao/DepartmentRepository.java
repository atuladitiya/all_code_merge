package com.spring.docker.feature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.docker.feature.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Query("SELECT d FROM Department d WHERE LOWER(d.departmentName) = LOWER(:departmentName)")
    public Department findByDepartmentNameIgnoreCaseJPQL(@Param("departmentName") String departmentName);
}