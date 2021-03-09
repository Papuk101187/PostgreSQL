package org.example;

import lombok.Data;

import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
public class JdbcTemplate {


    private String userbas = "postgres";
    private String password = "10n11m87g";
    private String dsn = "jdbc:postgresql://localhost:5432/basecontacts";


    public <T> List<T> query(String sql, Object[] params, RowMapper<T> mapper) throws SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);

        PreparedStatement statement1 = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement1.setObject(i + 1, params[i]);
        }

        ResultSet res = statement1.executeQuery();

        List<T> rezult = new ArrayList<>();

        while (res.next()) {
            T o = mapper.map(res);
            rezult.add(o);
        }

        return rezult;
    }

    public <T> List<T> query(String sql, RowMapper<T> mapper) throws SQLException {
        List<T> rezult = new ArrayList<>();
        rezult = query(sql, new Object[]{}, mapper);
        return rezult;
    }

    public <T> List<T> queryOne(String sql, Object[] params, RowMapper<T> mapper) throws SQLException {

        int count = 0;
        Connection connection = DriverManager.getConnection(dsn, userbas, password);

        PreparedStatement statement1 = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement1.setObject(i + 1, params[i]);
        }

        ResultSet res = statement1.executeQuery();

        List<T> rezult = new ArrayList<>();

        while (res.next()) {
            T o = mapper.map(res);
            if (count < 1) {
                rezult.add(o);
            }
            count++;
        }

        return rezult;
    }

    public <T> List<T> queryOne(String sql, RowMapper<T> mapper) throws SQLException {
        List<T> rezult = queryOne(sql, new Object[]{}, mapper);
        System.out.println(rezult.size());
        return rezult;
    }


    public void update(String sql, Object[] params) throws SQLException {


        Connection connection = DriverManager.getConnection(dsn, userbas, password);

        PreparedStatement statement1 = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            statement1.setObject(i + 1, params[i]);
        }

        statement1.executeUpdate();

    }


    public void update(String sql) throws SQLException {
        update(sql, new Object[]{});

    }


}
