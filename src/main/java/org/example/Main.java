package org.example;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {


        String sql_select = "SELECT name_contact" +
                " , surname_contact" +
                " , patronymic_contact FROM contacts;"; // запрос для выборки;

        String sql_insert = "INSERT INTO users " +
                "(FIO_user, " +
                "login_password," +
                " date_born_user) " +
                "Values (?, ? ,?);"; // запрос для вставки;

        String sql_update = "UPDATE users" +
                " SET login_password=? " +
                "WHERE id_user=?;";    // запрос для изменения;


        String sql_delete = "DELETE" +
                " FROM users " +
                "WHERE id=?;"; // запрос для удаления;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(); // класс для работы с БД;
        jdbcTemplate.update(sql_update, new Object[]{"777777", 1});
    }
}
