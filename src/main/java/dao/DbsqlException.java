package dao;

public class DbsqlException extends Exception {

    String message;

    public DbsqlException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
