package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ContactRobMapper implements RowMapper<Contact> {

    @Override
    public Contact map(ResultSet result) throws SQLException {
        Contact contact = new Contact();
        contact.setName(result.getString("name_contact"));
        contact.setValue(result.getString("surname_contact"));
        contact.setType(result.getString("patronymic_contact"));
        return contact;
    }

}
