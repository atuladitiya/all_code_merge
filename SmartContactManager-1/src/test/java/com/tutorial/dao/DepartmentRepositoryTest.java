package com.tutorial.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.tutorial.entity.Department;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {
@Autowired
private DepartmentRepository repo;
@Autowired
private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {
		Department department = new Department();
		department.setDepartmentName("ECE");
        department.setDepartmentCode("IT-123");
        department.setDepartmentBranch("Head Office");
        
        entityManager.persist(department);
	}
@Test
public void whenFindByIdthenReturnDepartment() {
	Department department = repo.findById(2L).get();

    // Assertions
     // Ensure the department is found
    assertEquals(department.getDepartmentName(),"ECE");
}

}
