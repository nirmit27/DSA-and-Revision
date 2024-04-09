/* Example of Method Overriding i.e.
RUN-TIME or DYNAMIC Polymorphism */

class Parent {
    void example() {
        System.out.println("This is the PARENT class implementation.");
    }
}

class Child extends Parent {
    @Override
    void example() {
        System.out.println("This is the CHILD class implementation.");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();

        child.example();
        parent.example();
    }
}
