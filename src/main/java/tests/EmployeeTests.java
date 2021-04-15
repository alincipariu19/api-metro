package tests;

import io.restassured.response.Response;
import models.requestbodies.BaseRequestBody;
import models.employeemodels.EmployeeDataProvider;
import models.requestbodies.EmployeeModelRequest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static utilities.Constants.*;
import static utilities.RestActions.*;
import static utilities.Utils.getEmployeesOver30;

public class EmployeeTests {

    @Test(description = "Retrieve all employees")
    public void getAllEmployees() {

        Response response = doGetRequest(BASE_URL, GET_ALL_EMPLOYEES);
        assertEquals(getEmployeesOver30(response), 16);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Retrieve one employee")
    public void getOneEmployee() {

        Response response = doGetRequest(BASE_URL, GET_SINGLE_EMPLOYEE);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Create employee",
            dataProvider = "CreateEmployee", dataProviderClass = EmployeeDataProvider.class)
    public void createEmployee(String name, String salary, String age) {

        BaseRequestBody body = new EmployeeModelRequest(name, salary, age);
        Response response = doPostRequest(BASE_URL, CREATE_EMPLOYEE, body);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Update employee",
            dataProvider = "UpdateEmployee", dataProviderClass = EmployeeDataProvider.class)
    public void updateEmployee(String name, String salary, String age) {

        BaseRequestBody body = new EmployeeModelRequest(name, salary, age);
        Response response = doPutRequest(BASE_URL, UPDATE_EMPLOYEE, body);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Delete employee")
    public void deleteEmployee() {

        Response response = doDeleteRequest(BASE_URL, DELETE_EMPLOYEE);
        assertEquals(response.getStatusCode(), 200);
    }
}
