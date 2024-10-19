public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Create and add a new employee
        Employee employee = new Employee("John Doe", "johndoe@example.com", "123-456-7890");
        directory.addEmployee(employee);

        // Search for the employee
        Employee foundEmployee = directory.searchEmployee("John Doe");
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found.");
        }

        // Update the employee's email
        employee.setEmail("johndoe2@example.com");
        directory.updateEmployee(employee);

        // Delete the employee
        directory.deleteEmployee("John Doe");

        // Confirm deletion
        foundEmployee = directory.searchEmployee("John Doe");
        if (foundEmployee == null) {
            System.out.println("Employee has been deleted and not found in the directory.");
        } else {
            System.out.println("Employee still found after deletion: " + foundEmployee.getName());
        }
    }
}
