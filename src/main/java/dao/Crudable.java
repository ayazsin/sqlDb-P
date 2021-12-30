package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Crudable <T> {

    T get(int id) throws SQLException;
    ArrayList<T> get() throws SQLException;
    boolean delete(int id) throws SQLException;
    public boolean add(T o) throws SQLException;
    public boolean update(T o) throws SQLException;


}
