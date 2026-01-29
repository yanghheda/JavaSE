package training_object.service;

import training_object.domain.*;

import static training_object.service.Data.*;

/**
 * 负责将Data中的数组封装到Employee[]数组中，同时提供相关的操作Employee[]的方法。
 */

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int sock;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    sock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, sock);
            }
        }
    }

    private Equipment createEquipment(int index) {
        int equipmentType = Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName = EQUIPMENTS[index][1];
        String priceOrDisplayOrType = EQUIPMENTS[index][2];

        switch (equipmentType) {
            case PC:
                return new PC(modelOrName, priceOrDisplayOrType);
            case NOTEBOOK:
                double price = Double.parseDouble(priceOrDisplayOrType);
                return new NoteBook(modelOrName, price);
            case PRINTER:
                return new Printer(modelOrName, priceOrDisplayOrType);
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定id对应的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
