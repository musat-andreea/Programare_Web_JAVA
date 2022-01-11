package com.andreea.proiectjavafacultate.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection SINGLETON = null;

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DatabaseConnection(){
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/agency",
                            "root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance(){
        if(SINGLETON == null){
            SINGLETON = new DatabaseConnection();
        }

        return SINGLETON;
    }
}
