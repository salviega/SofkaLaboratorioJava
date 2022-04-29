package repository;

import connection.SqlConnection;
import entity.Status;

import java.sql.SQLException;

public class StatusRepository extends SqlConnection {

    private final Status status = new Status();

    public StatusRepository() {
        this.tableName = "statuses";
        this.key = "id";
    }

    @Override
    public Status findById(Integer id) {
        super.findById(id);
        return this.rowMapper();
    }

    private Status rowMapper() {
        try {
            while (this.resultSet.next()) {
                this.status.setId(this.resultSet.getInt(1));
                this.status.setDescription(this.resultSet.getString(2));
            }
            return this.status;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
