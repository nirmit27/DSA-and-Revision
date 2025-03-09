package College.Beans;

/* An example of a Java Bean. */
import java.io.Serializable;

public class Employee implements Serializable { // Implementing Serializable interface

    // Private instance variables
    private int id;
    private String name;

    public Employee() { // A constructor with NO arguments
    };

    // Public getter and setter methods for all instance variables
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
