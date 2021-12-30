package jdbc;

import java.sql.*;

public class JavaExcecute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root", "root1234");

        Statement st = connection.createStatement();

        String q0 = "SELECT * FROM Employee";

        ResultSet r1 = st.executeQuery(q0);

        while (r1.next()) {
            System.out.println(r1.getInt(1) + " - " + r1.getString(2) + " - " + r1.getString(3));
        }

        connection.close();
        st.close();
        r1.close();


    }
}
