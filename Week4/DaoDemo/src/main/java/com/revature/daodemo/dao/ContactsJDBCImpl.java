package com.revature.daodemo.dao;

import com.revature.daodemo.model.Contacts;
import com.revature.daodemo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactsJDBCImpl implements ContactDAO{
    Connection connection=null;
    public Contacts getContact(int id){
        connection= ConnectionUtil.dbConnection();
        Contacts contacts=null;
        String getContact="select * from contact_list where id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(getContact);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                contacts=new Contacts(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    @Override
    public List<Contacts> getAllContacts() {
        return List.of();
    }

    @Override
    public void save(Contacts contacts) {

    }

    @Override
    public Contacts update(Contacts contacts) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}