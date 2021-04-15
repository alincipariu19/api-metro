package models.employeemodels;

import org.testng.annotations.DataProvider;

public class EmployeeDataProvider {

    @DataProvider(name = "CreateEmployee")
    public Object[][] dpCreateEmployee() {
        String name = "test";
        String salary = "123";
        String age = "23";
        return new Object[][]{{name, salary, age}};
    }

    @DataProvider(name = "UpdateEmployee")
    public Object[][] dpUpdateEmployee() {
        String name = "John Smith";
        String salary = "456";
        String age = "33";
        return new Object[][]{{name, salary, age}};
    }
}
