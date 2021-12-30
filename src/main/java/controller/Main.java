package controller;

import bean.Employee;
import dao.Dao;
import dao.DaoEmployee;
import dao.DbsqlException;

import java.sql.SQLException;

public class Main {
    double s;

    public static void main(String[] args) throws DbsqlException, SQLException {

        Employee employee = new Employee(6, "Hayri", "Far", 4000, 4);
        DaoEmployee daoEmployee = new DaoEmployee();
        System.out.println("Mon 3. employee ---> " + daoEmployee.get(3));
        daoEmployee.delete(10);
        daoEmployee.add(employee);
        daoEmployee.update(employee);

        daoEmployee.get();
        employee = (Employee) daoEmployee.get(3);
        daoEmployee.print();

        System.out.println(daoEmployee.get(3));







    }
}
