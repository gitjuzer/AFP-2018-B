package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    private Connection connection = null;

    private boolean getConnection() {
        String url = "jdbc:mysql://localhost:3306/rest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "";
        String password = "";
        boolean successful = true;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
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
