package com.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());

    public User getDetails(String username) {
        User user = null;

        try {
            Connection connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from user where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .name(resultSet.getString("name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .build();
                //TODO use mapconstruct
            }
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Could not execute query", exception);
        }
        return user;
    }
}
