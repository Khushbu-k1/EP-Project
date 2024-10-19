import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;

public class EmployeeDirectory {
    private Context ctx;

    public EmployeeDirectory() {
        initializeContext();
    }

    private void initializeContext() {
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            System.err.println("JNDI Error during context initialization: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        try {
            ctx.bind(employee.getName(), employee.getReference());
            System.out.println("Employee added: " + employee.getName());
        } catch (NamingException e) {
            System.err.println("JNDI Error while adding employee: " + e.getMessage());
        }
    }

    public Employee searchEmployee(String name) {
        try {
            Reference ref = (Reference) ctx.lookup(name);
            if (ref != null) {
                String empName = (String) ref.get("name").getContent();
                String email = (String) ref.get("email").getContent();
                String phoneNumber = (String) ref.get("phoneNumber").getContent();
                return new Employee(empName, email, phoneNumber);
            }
        } catch (NamingException e) {
            System.err.println("JNDI Error while searching for employee: " + e.getMessage());
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        try {
            ctx.rebind(employee.getName(), employee.getReference());
            System.out.println("Employee updated: " + employee.getName());
        } catch (NamingException e) {
            System.err.println("JNDI Error while updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(String name) {
        try {
            ctx.unbind(name);
            System.out.println("Employee deleted: " + name);
        } catch (NamingException e) {
            System.err.println("JNDI Error while deleting employee: " + e.getMessage());
        }
    }
}
