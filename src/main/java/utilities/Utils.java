package utilities;

import io.restassured.response.Response;
import models.responses.EmployeeModelResponse;
import models.employeemodels.EmployeeResponseData;

import java.util.List;

public class Utils {
    public static int getEmployeesOver30(Response response){
        int count = 0;
        EmployeeModelResponse modelResponse = response.getBody().as(EmployeeModelResponse.class);
        List<EmployeeResponseData> employeeList = modelResponse.getData();

        for (EmployeeResponseData data : employeeList) {
            if (Integer.parseInt(data.getEmployeeAge()) > 30) {
                count++;
            }
        }
        return count;
    }
}
