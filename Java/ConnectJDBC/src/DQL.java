import java.sql.*;
import java.util.*;
import java.lang.System;

public class DQL {

    public static List<String> fetchDetails() {
        try (Scanner sc = new Scanner(System.in)) {
            List<String> creds = new ArrayList<String>();

            System.out.print("\nUsername : ");
            String user = sc.next();
            creds.add(user);

            System.out.print("Password : ");
            String pwd = sc.next();
            creds.add(pwd);

            System.out.print("Database : ");
            String db = sc.next();
            creds.add(db);

            sc.nextLine(); // for skipping the newline

            System.out.print("Query : ");
            String q = sc.nextLine();
            creds.add(q);

            return creds;
        }
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Class.forName(
                "com.mysql.cj.jdbc.Driver"); // JDBC Driver name

        // Fetching connection details
        List<String> creds = fetchDetails();
        String connectionString = String.format("jdbc:mysql://localhost:3306/%s", creds.get(2));

        // Establishing the connection
        Connection con = DriverManager.getConnection(connectionString, creds.get(0), creds.get(1));
        System.out.println(String.format("\nConnection established with database : %s", creds.get(2)));

        // Creating the query statement
        Statement stmt = con.createStatement();

        // Generating result set
        ResultSet result = stmt.executeQuery(creds.getLast());

        // Displaying the result
        System.out.println("\nNames of all the tables :\n");
        while (result.next()) {
            System.out.println(result.getString("Tables_in_web_scrape"));
        }

        // Wrapping things up
        stmt.close();
        con.close();
        System.out.println("\n\nClosing the connection ...\n");
    }
}