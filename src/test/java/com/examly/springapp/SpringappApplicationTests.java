package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

//DAY 3 
@Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
    @Order(2)
    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
    @Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
    @Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }

    // DAY 4 - Model Tests
    @Test
    @Order(5)
    void Day4_test_UserModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/User.java").isFile());
    }

    @Test
    @Order(6)
    void Day4_test_DepartmentModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Department.java").isFile());
    }

    @Test
    @Order(7)
    void Day4_test_JobApplicationModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/JobApplication.java").isFile());
    }

    @Test
    @Order(8)
    void Day4_test_JobPosition_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/JobPosition.java").isFile());
    }

    @Test
    @Order(9)
    void Day4_test_InterviewFeedback_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/InterviewFeedback.java").isFile());
    }

    @Test
    @Order(10)
    void Day4_test_JobApplication_Has_Entity_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.JobApplication");
            Class<?> annotation = Class.forName("jakarta.persistence.Entity");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Entity annotation is missing on JobApplication class");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplication class not found.");
        }
    }

    @Test
    @Order(11)
    void Day4_test_JobApplication_Has_Id_Annotation_On_Field() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.JobApplication");
            Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");
            boolean found = false;
            for (var field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No field in JobApplication class is annotated with @Id");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplication class not found.");
        }
    }

    // DAY 5 - Repository Tests
    @Test
    @Order(12)
    void Day5_test_UserRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/UserRepository.java").isFile());
    }

    @Test
    @Order(13)
    void Day5_test_DepartmentRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/DepartmentRepository.java").isFile());
    }

    @Test
    @Order(14)
    void Day5_test_JobApplicationRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/JobApplicationRepository.java").isFile());
    }

    @Test
    @Order(15)
    void Day5_test_JobPositionRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/JobPositionRepository.java").isFile());
    }

    @Test
    @Order(16)
    void Day5_test_InterviewFeedbackRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/InterviewFeedbackRepository.java").isFile());
    }

    @Test
    @Order(17)
    void Day5_test_UserRepository_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.UserRepository");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on UserRepository class");
        } catch (ClassNotFoundException e) {
            fail("❌ UserRepository class not found.");
        }
    }

    @Test
    @Order(18)
    void Day5_test_DepartmentRepository_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.DepartmentRepository");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on DepartmentRepository class");
        } catch (ClassNotFoundException e) {
            fail("❌ DepartmentRepository class not found.");
        }
    }

    @Test
    @Order(19)
    void Day5_test_JobApplicationRepository_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.JobApplicationRepository");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on JobApplicationRepository class");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationRepository class not found.");
        }
    }

    @Test
    @Order(20)
    void Day5_test_JobPositionRepository_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.JobPositionRepository");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on JobPositionRepository class");
        } catch (ClassNotFoundException e) {
            fail("❌ JobPositionRepository class not found.");
        }
    }

    @Test
    @Order(21)
    void Day5_test_InterviewFeedbackRepository_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.InterviewFeedbackRepository");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on InterviewFeedbackRepository class");
        } catch (ClassNotFoundException e) {
            fail("❌ InterviewFeedbackRepository class not found.");
        }
    }

    // DAY 6 - Controller Tests
    @Test
    @Order(22)
    void Day6_test_UserController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/UserController.java").isFile());
    }

    @Test
    @Order(23)
    void Day6_test_DepartmentController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/DepartmentController.java").isFile());
    }

    @Test
    @Order(24)
    void Day6_test_JobApplicationController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/JobApplicationController.java").isFile());
    }

    @Test
    @Order(25)
    void Day6_test_JobPositionController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/JobPositionController.java").isFile());
    }

    @Test
    @Order(26)
    void Day6_test_InterviewFeedbackController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/InterviewFeedbackController.java").isFile());
    }

    @Test
    @Order(27)
    void Day6_test_UserController_Has_RestController_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @RestController annotation is missing on UserController class");
        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        }
    }

    @Test
    @Order(28)
    void Day6_test_JobApplicationController_Has_RestController_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");
            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @RestController annotation is missing on JobApplicationController class");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(29)
    void Day6_test_JobApplicationController_Has_PostMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No method with @PostMapping found in JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(30)
    void Day6_test_JobApplicationController_Has_GetMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No @GetMapping method found in JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(31)
    void Day6_test_JobApplicationController_Has_PutMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No @PutMapping method found in JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(32)
    void Day6_test_JobApplicationController_Has_DeleteMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> deleteMapping = Class.forName("org.springframework.web.bind.annotation.DeleteMapping");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) deleteMapping)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No @DeleteMapping method found in JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(33)
    public void Day6_testCreateJobApplication_NoBody_StatusBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/job-applications")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @Order(34)
    public void Day6_testGetAllJobApplications_StatusNoContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/job-applications"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @Order(35)
    public void Day6_testGetJobApplicationById_StatusNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/job-applications/999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content()
                        .string(org.hamcrest.Matchers.containsString("Job application not found")));
    }

    // DAY 7
    @Test
    @Order(36)
    void Day7_test_UserController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");
            boolean found = clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping);
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "❌ No @RequestMapping found on UserController");
        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        }
    }

    @Test
    @Order(37)
    void Day7_test_UserController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            assertTrue(found, "❌ No @PathVariable found in UserController");
        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        }
    }

    @Test
    @Order(38)
    void Day7_test_JobApplicationController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");
            boolean found = clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping);
            assertTrue(found, "❌ No @RequestMapping found on JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(39)
    void Day7_test_DepartmentController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.DepartmentController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");
            boolean found = clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping);
            assertTrue(found, "❌ No @RequestMapping found on DepartmentController");
        } catch (ClassNotFoundException e) {
            fail("❌ DepartmentController class not found.");
        }
    }

    @Test
    @Order(40)
    void Day7_test_JobApplicationController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobApplicationController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            assertTrue(found, "❌ No @PathVariable found in JobApplicationController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobApplicationController class not found.");
        }
    }

    @Test
    @Order(41)
    void Day7_test_DepartmentController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.DepartmentController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");
            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            assertTrue(found, "❌ No @PathVariable found in DepartmentController");
        } catch (ClassNotFoundException e) {
            fail("❌ DepartmentController class not found.");
        }
    }

    @Test
    @Order(42)
    void Day7_test_JobPositionController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.JobPositionController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");
            boolean found = clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping);
            assertTrue(found, "❌ No @RequestMapping found on JobPositionController");
        } catch (ClassNotFoundException e) {
            fail("❌ JobPositionController class not found.");
        }
    }

    // DAY 8 - Service Tests
    @Test
    @Order(43)
    void Day8_test_UserService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/UserService.java").isFile());
    }

    @Test
    @Order(44)
    void Day8_test_DepartmentService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/DepartmentService.java").isFile());
    }

    @Test
    @Order(45)
    void Day8_test_JobApplicationService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/JobApplicationService.java").isFile());
    }

    @Test
    @Order(46)
    void Day8_test_JobPositionService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/JobPositionService.java").isFile());
    }

    @Test
    @Order(47)
    void Day8_test_InterviewFeedbackService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/InterviewFeedbackService.java").isFile());
    }

    @Test
    @Order(48)
    void Day8_test_UserServiceImpl_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/UserServiceImpl.java").isFile());
    }

    @Test
    @Order(49)
    void Day8_test_DepartmentServiceImpl_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/DepartmentServiceImpl.java").isFile());
    }

    @Test
    @Order(50)
    void Day8_test_JobApplicationServiceImpl_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/JobApplicationServiceImpl.java").isFile());
    }

    @Test
    @Order(51)
    void Day8_test_JobPositionServiceImpl_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/JobPositionServiceImpl.java").isFile());
    }

    @Test
    @Order(52)
    void Day8_test_InterviewFeedbackServiceImpl_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/InterviewFeedbackServiceImpl.java").isFile());
    }

    @Test
    @Order(53)
    public void Day8_testAddDepartment() throws Exception {
        String requestBody = "{ " +
            "\"departmentName\": \"Engineering Department\", " +
            "\"contactEmail\": \"engineering@example.com\", " +
            "\"contactPhone\": \"9876543210\" " +
        "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Engineering Department"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactEmail").value("engineering@example.com"))
                .andReturn();
    }

    @Test
    @Order(54)
    public void Day8_testGetAllDepartments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departmentName").value("Engineering Department"))
                .andReturn();
    }

    @Test
    @Order(55)
    public void Day8_testGetDepartmentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Engineering Department"))
                .andReturn();
    }

    @Test
    @Order(56)
    public void Day8_testUpdateDepartment() throws Exception {
        String requestBody = "{" +
            "\"departmentName\": \"Software Engineering Department\", " +
            "\"contactEmail\": \"software.eng@example.com\", " +
            "\"contactPhone\": \"9999999999\"" +
        "}";
        mockMvc.perform(MockMvcRequestBuilders.put("/api/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value("Software Engineering Department"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactEmail").value("software.eng@example.com"))
                .andReturn();
    }

    // DAY 9 - Pagination
    @Test
    @Order(57)
    public void Day9_testPagination_PageNumberApplied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
    }

    @Test
    @Order(58)
    public void Day9_testPagination_PageSizeApplied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/1/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
    }

    @Test
    @Order(59)
    public void Day9_testPagination_SortingPresent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort.sorted").isBoolean());
    }

    @Test
    @Order(60)
    public void Day9_testPagination_ContentArrayExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
    }

    @Test
    @Order(61)
    public void Day9_testPagination_TotalElementsExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
    }

    @Test
    @Order(62)
    public void Day9_testPagination_TotalPagesExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
    }

        // DAY 10 - User CRUD
        @Test
        @Order(63)
        public void Day10_testAddUser() throws Exception {
            String requestBody = "{ " +
                "\"username\": \"test_candidate\", " +
                "\"email\": \"candidate@example.com\", " +
                "\"password\": \"password123\", " +
                "\"role\": \"CANDIDATE\", " +
                "\"phoneNumber\": \"1234567890\", " +
                "\"department\": { \"departmentId\": 1 } " +
            "}";
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("test_candidate"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("candidate@example.com"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("CANDIDATE"))
                    .andReturn();
        }

        @Test
        @Order(64)
        public void Day10_testGetAllUsers() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("test_candidate"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("candidate@example.com"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("CANDIDATE"))
                    .andReturn();
        }
        

        @Test
@Order(65)
public void Day10_testGetUserById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("test_candidate"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("candidate@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("CANDIDATE"))
            .andReturn();
}

@Test
@Order(66)
public void Day10_testUpdateUser() throws Exception {
    String requestBody = "{ " +
        "\"username\": \"updated_test_candidate\", " +
        "\"email\": \"updated_candidate@example.com\", " +
        "\"role\": \"OFFICER\", " +
        "\"phoneNumber\": \"9999999999\" " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/users/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("updated_test_candidate"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("updated_candidate@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("OFFICER"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("9999999999"))
            .andReturn();
}

@Test
@Order(67)
public void Day10_testAddJobPosition() throws Exception {
    // First, create a department
    String deptBody = "{ " +
        "\"departmentName\": \"Engineering\", " +
        "\"contactEmail\": \"engineering@example.com\", " +
        "\"contactPhone\": \"9876543210\" " +
    "}";
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(deptBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    String requestBody = "{ " +
        "\"positionTitle\": \"Senior Java Developer\", " +
        "\"description\": \"Looking for experienced Java developers\", " +
        "\"location\": \"Bangalore\", " +
        "\"experienceRequired\": \"3-5 years\", " +
        "\"openings\": 2, " +
        "\"department\": { \"departmentId\": 1 } " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/job-positions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.positionTitle").value("Senior Java Developer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Looking for experienced Java developers"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.location").value("Bangalore"))
            .andReturn();
}


@Test
@Order(68)
public void Day10_testGetAllJobPositions() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/job-positions")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].positionTitle").value("Senior Java Developer")) 
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Looking for experienced Java developers"))
            .andReturn();
}

@Test
@Order(69)
public void Day10_testGetJobPositionById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/job-positions/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.positionTitle").value("Senior Java Developer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Looking for experienced Java developers"))
            .andReturn();
}

@Test
@Order(70)
public void Day10_testUpdateJobPosition() throws Exception {
    String requestBody = "{ " +
        "\"positionTitle\": \"Lead Java Developer\", " +
        "\"description\": \"Updated description for senior Java role\", " +
        "\"location\": \"Bangalore\", " +
        "\"experienceRequired\": \"5-8 years\", " +
        "\"openings\": 3 " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/job-positions/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.positionTitle").value("Lead Java Developer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Updated description for senior Java role"))
            .andReturn();
}

@Test
@Order(71)
public void Day11_testSearchJobPositions() throws Exception {
    // Create another position for search testing
    String requestBody = "{ " +
        "\"positionTitle\": \"Python Developer\", " +
        "\"description\": \"Backend Python development role\", " +
        "\"location\": \"Mumbai\", " +
        "\"experienceRequired\": \"2-4 years\", " +
        "\"openings\": 1, " +
        "\"department\": { \"departmentId\": 1 } " +
    "}";
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/job-positions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    // Test search for "Python" keyword
    mockMvc.perform(MockMvcRequestBuilders.get("/api/job-positions/search/Python")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].positionTitle").value("Python Developer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Backend Python development role"))
            .andReturn();
}

@Test
@Order(72)
public void Day12_testAddInterviewFeedback() throws Exception {
    // First, create a user (candidate)
    String userBody = "{ " +
        "\"username\": \"john_candidate\", " +
        "\"email\": \"john@example.com\", " +
        "\"password\": \"password123\", " +
        "\"role\": \"CANDIDATE\", " +
        "\"phoneNumber\": \"9876543210\" " +
    "}";
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userBody))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    // Create a job application
    String applicationBody = "{ " +
        "\"coverLetter\": \"I am interested in this position\", " +
        "\"resumeUrl\": \"/resumes/john_resume.pdf\", " +
        "\"status\": \"INTERVIEW\", " +
        "\"priority\": \"HIGH\", " +
        "\"candidate\": { \"userId\": 1 }, " +
        "\"jobPosition\": { \"positionId\": 1 } " +
    "}";
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/job-applications")
            .contentType(MediaType.APPLICATION_JSON)
            .content(applicationBody))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn();
    
    // Create interview feedback
    String feedbackBody = "{ " +
        "\"content\": \"Candidate performed well in technical round\", " +
        "\"isInternal\": false, " +
        "\"interviewRound\": \"Technical Round 1\", " +
        "\"jobApplication\": { \"applicationId\": 1 }, " +
        "\"user\": { \"userId\": 1 } " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/interview-feedbacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(feedbackBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Candidate performed well in technical round"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(false))
            .andExpect(MockMvcResultMatchers.jsonPath("$.interviewRound").value("Technical Round 1"))
            .andReturn();
}

@Test
@Order(73)
public void Day12_testGetAllInterviewFeedbacks() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/interview-feedbacks")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("Candidate performed well in technical round"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].isInternal").value(false))
            .andReturn();
}

@Test
@Order(74)
public void Day12_testGetInterviewFeedbackById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/interview-feedbacks/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Candidate performed well in technical round"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(false))
            .andReturn();
}

@Test
@Order(75)
public void Day12_testUpdateInterviewFeedback() throws Exception {
    String requestBody = "{ " +
        "\"content\": \"Updated feedback: Excellent problem-solving skills\", " +
        "\"isInternal\": true, " +
        "\"interviewRound\": \"Technical Round 1\" " +
    "}";

    mockMvc.perform(MockMvcRequestBuilders.put("/api/interview-feedbacks/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Updated feedback: Excellent problem-solving skills"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.isInternal").value(true))
            .andReturn();
}

@Test
@Order(76)
public void Day12_testGetFeedbacksByJobApplication() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/interview-feedbacks/application/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("Updated feedback: Excellent problem-solving skills"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].isInternal").value(true))
            .andReturn();
}







@Test
@Order(77)
    void Day13_test_execption_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }


	
@Test
@Order(78)
void Day13_test_GloabalEception_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
}


@Test
@Order(79)
    void Day14test_configuartion_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

@Test
@Order(80)
public void Day15_testAOPLogFileExists() {

    assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
   
}



}




















