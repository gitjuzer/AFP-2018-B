package com.mycompany.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    private Connection connection = null;
    private String url;
    private String user;
    private String password;

    private boolean readSettings() {
        boolean successful = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/dbConnection/db_connection.txt"));
            url = reader.readLine();
            user = reader.readLine();
            password = reader.readLine();
        } catch (Exception e) {
            successful = false;
        }
        return successful;
    }

    private boolean getConnection() {
        boolean successful = true;

        try {
//            if (!readSettings()) {
//                throw new SQLException();
//            }
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://donfamilia:3306/quiz","quiz","quiz");
            //connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            successful = false;
        }

        return successful;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        if (!getConnection()) {
            throw new SQLException();
        }

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        return result;
    }

    public ResultSet executePreparedQuery(String query, ArrayList<String> params) throws SQLException {
        if (!getConnection()) {
            throw new SQLException();
        }

        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.size(); i++) {
            statement.setString(i + 1, params.get(i));
        }

        ResultSet result = statement.executeQuery();

        return result;
    }

    public int executeInsertStatement(String query, ArrayList<String> params) throws SQLException {
        if (!getConnection()) {
            throw new SQLException();
        }

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.size(); i++) {
            statement.setString(i + 1, params.get(i));
        }
        int rowAffected = statement.executeUpdate();
        int insertedId = -1;

        if (rowAffected == 1) {
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                insertedId = result.getInt(1);
            }
        }

        return insertedId;
    }
}
