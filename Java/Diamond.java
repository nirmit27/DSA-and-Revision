/* Diamond problem of Multiple Inheritance solved using Interfaces */

interface Interface0 {
    default void show(String name, long urn) {
        System.out.println(String.format("Name : %s\tURN : %d", name, urn));
    }
}

interface Interface1 extends Interface0 {
    void showName(String name);
}

interface Interface2 extends Interface0 {
    void showURN(long urn);
}

public class Diamond implements Interface1, Interface2 {
    @Override
    public void showName(String name) {
        System.out.println(String.format("\nName : %s", name));
    }

    @Override
    public void showURN(long urn) {
        System.out.println(String.format("\nURN : %d", urn));
    }

    public static void main(String[] args) {
        Diamond di = new Diamond();
        di.show("Nirmit Mishra", 2100560100064L);
        di.showName("Nirmit Mishra");
        di.showURN(2100560100064L);
    }
}
