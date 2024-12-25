// Accessing a Java Beans class ...
package College;

import java.util.Scanner;
import Beans.Employee;

public class BeanTest {
    public static void main(String[] args) {
        int id;
        String name;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter employee ID : ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter employee name : ");
            name = sc.nextLine();
        }
        Employee employee = new Employee(); // Creating a Java Bean object

        employee.setId(id);
        System.out.println(String.format("\nEmployee ID : %d", employee.getId()));

        employee.setName(name);
        System.out.println(String.format("\nEmployee Name : %s", employee.getName()));
    }
}
