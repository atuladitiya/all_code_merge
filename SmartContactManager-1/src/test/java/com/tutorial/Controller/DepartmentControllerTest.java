package com.tutorial.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.entity.Department;
import com.tutorial.services.departmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private departmentService service;

    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
        department.setDepartmentName("kiit");
        department.setDepartmentCode("IT-00");
        department.setDepartmentBranch("Main Office Branch");
        department.setDepartmentId(303L);
    }

    @Test
    void save() throws Exception {
        Department inputDepartment = new Department();
        inputDepartment.setDepartmentName("kiit");
        inputDepartment.setDepartmentCode("IT-00");
        inputDepartment.setDepartmentBranch("Main Office Branch");

        Mockito.when(service.saveDepartment(inputDepartment)).thenReturn(department);

        // Perform the POST request and capture the response
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/department/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n"
                		+ "    \"departmentName\":\"kiit\",\r\n"
                		+ "    \"departmentCode\":\"IT-00\",\r\n"
                		+ "    \"departmentBranch\":\"Main Office Branch\"\r\n"
                		+ "}"))
        		           .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(service.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/getById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}
