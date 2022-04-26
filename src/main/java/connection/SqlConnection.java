package connection;

import java.sql.*;

public abstract class SqlConnection {

    protected String tableName;
    protected String key;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    protected SqlConnection() {
    }

    protected Connection getConnection() {
            String connectionURL = "jdbc:sqlserver://DESKTOP-2JKL1SJ;databaseName=LaboratorioJava;";
            String user = "sergio";
            String pass = "1234";

        try {
            return DriverManager.getConnection(connectionURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object findById(Integer id) {
        String query = String.format("SELECT * FROM %s WHERE %s = %s", this.tableName, this.key, id);
        try {
            this.preparedStatement = this.getConnection().prepareStatement(query);
            this.resultSet = this.preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
