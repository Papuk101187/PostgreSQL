package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    T map(ResultSet result) throws SQLException;

}
