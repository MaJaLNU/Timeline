package com.timeline.utils.databaseHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Jan on 22.11.2016.
 */
public class UserHelper {

    /**
     * Check if a user for given email address exists with given password
     * @param email email address of user
     * @param password password of user
     * @return true if valid login
     */
    public boolean authenticate(String email, String password) {
        boolean loginOK = false;
        try {
            Connection connection = DatabaseHelper.connect();

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT password FROM user WHERE email = '" + email + "'");

            if(!result.isBeforeFirst()) {
                //TODO no such user with email
            }
            else {
                result.first();
                if (result.getString("password").equals(password)) loginOK = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginOK;
    }
}
