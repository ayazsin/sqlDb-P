package dao;

import bean.Employee;

import java.sql.*;
import java.util.ArrayList;


public class DaoEmployee implements Crudable<Employee>{


    private ArrayList<Employee> employeeList;




    @Override
    public Employee get(int id) throws SQLException {

        Statement st = Dao.getConnection().createStatement();

        Employee employee = new Employee();
        String q = "SELECT * FROM EMPLOYEE.Employee WHERE id = " + id;
        ResultSet rs = st.executeQuery(q);
         if (rs.next()) {
            employee = new Employee( rs.getInt(1) , rs.getString(2),rs.getString(3) ,rs.getDouble(4) , rs.getInt(5));
         }

         Dao.closeStatement(st);
         Dao.closeConnection();
         Dao.closeResultSet(rs);

        return employee;
    }

    @Override
    public ArrayList get() throws SQLException {

        Statement st1 = Dao.getConnection().createStatement();
        employeeList = new ArrayList<>();
        String q1 = "SELECT * FROM EMPLOYEE.Employee";
        ResultSet rs1 = st1.executeQuery(q1);
        while (rs1.next()) {
         employeeList.add(new Employee( rs1.getInt(1) , rs1.getString(2),rs1.getString(3) ,rs1.getDouble(4) , rs1.getInt(5)));
        }

        Dao.closeStatement(st1);
        Dao.closeConnection();
        Dao.closeResultSet(rs1);

        return employeeList;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        Statement st = Dao.getConnection().createStatement();
        String q = "DELETE FROM EMPLOYEE.Employee WHERE Id = " + id;
        st.executeUpdate(q);

        Dao.closeStatement(st);
        Dao.closeConnection();

        return false;
    }

    @Override
    public boolean add(Employee o) throws SQLException {
        Statement st1 = Dao.getConnection().createStatement();
        String q = "INSERT INTO EMPLOYEE.Employee (first_name, last_name, salary, year) VALUES ('"+ o.getFirst_name() +"', '" + o.getLast_name() +"', '"+ o.getSalary() +"', '" + o.getYear() + "')";
        st1.executeUpdate(q);

        Dao.closeStatement(st1);
        Dao.closeConnection();
        return false;
    }

    @Override
    public boolean update(Employee o) throws SQLException {
        Statement st = Dao.getConnection().createStatement();
        String q = "UPDATE EMPLOYEE.Employee " +
                "SET first_name = '" + o.getFirst_name() + "', last_name = '" +
                o.getLast_name() + "', salary = '" + o.getSalary() + "', " +
                "year = '" + o.getYear() + "' " +
                "WHERE id = " + o.getId();
        st.executeUpdate(q);

        return false;
    }


    public void print() {
        for (Employee emp : employeeList) {

            System.out.println(emp);
        }
    }


}
