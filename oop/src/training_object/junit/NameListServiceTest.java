package training_object.junit;

import org.junit.jupiter.api.Test;
import training_object.domain.Employee;
import training_object.service.NameListService;
import training_object.service.TeamException;

public class NameListServiceTest {
//    static void main() {
//        NameListService nameListService = new NameListService();
//        Employee[] employees = nameListService.getAllEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//    }
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployeeById(){
        try {
            NameListService nameListService = new NameListService();
            int id = 3;
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
