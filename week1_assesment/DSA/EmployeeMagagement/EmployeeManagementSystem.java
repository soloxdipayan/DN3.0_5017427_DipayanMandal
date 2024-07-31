public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + employees[i].getEmployeeId() + ", Name: " + employees[i].getName() +
                               ", Position: " + employees[i].getPosition() + ", Salary: " + employees[i].getSalary());
        }
    }

    // Delete employee by ID
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        
        ems.addEmployee(new Employee("1", "Alice", "Manager", 75000));
        ems.addEmployee(new Employee("2", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("3", "Charlie", "Designer", 55000));

     
        System.out.println("All Employees:");
        ems.traverseEmployees();

        Employee employee = ems.searchEmployee("2");
        if (employee != null) {
            System.out.println("\nFound Employee: " + employee.getName());
        } else {
            System.out.println("\nEmployee not found.");
        }

       
        ems.deleteEmployee("2");
        System.out.println("\nEmployees after deletion:");
        ems.traverseEmployees();
    }
}