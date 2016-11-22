package com.timeline.utils.databaseHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jan on 22.11.2016.
 */
public class DatabaseHelper {

    private static String host = null;
    private static String username = null;
    private static String password = null;
    private static Connection con = null;

    public static Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(con == null) {
                readProperties();
                con = DriverManager.getConnection(host, username, password);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            //throw new DatabaseConnectionException("An error occurred while connecting to the database", MyException.ERROR);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            //throw new DatabaseConnectionException("An error occurred while connecting to the database", MyException.ERROR);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            //throw new DatabaseConnectionException("An error occurred while connecting to the database", MyException.ERROR);
        }

        return con;
    }

    private static void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = DatabaseHelper.class.getResourceAsStream("database.properties");
        properties.load(inputStream);

        host = properties.getProperty("host");
        username = properties.getProperty("id");
        password = properties.getProperty("password");
        inputStream.close();
    }

}