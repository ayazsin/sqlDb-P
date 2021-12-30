package dao;

import java.sql.*;

import java.util.Properties;

public class Dao{


    private static Connection conn = null;

    public static Connection getConnection() {

        String url = ConfigReader.getProperty("dburl");
        String user = ConfigReader.getProperty("user");
        String password = ConfigReader.getProperty("password");
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }



    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }}



