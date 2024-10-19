import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Employee implements Referenceable {
    private String name;
    private String email;
    private String phoneNumber;

    public Employee(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public Reference getReference() throws NamingException {
        Reference ref = new Reference("Employee");
        ref.add(new StringRefAddr("name", name));
        ref.add(new StringRefAddr("email", email));
        ref.add(new StringRefAddr("phoneNumber", phoneNumber));
        return ref;
    }
}
