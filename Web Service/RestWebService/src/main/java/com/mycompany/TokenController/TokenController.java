/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.TokenController;

import com.mycompany.database.Database;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Dániel
 */
public class TokenController {
    public static String getToken(String user, String password) throws SQLException {
        String query = "SELECT token FROM users WHERE username = ? and password = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(user);
        params.add(password);

        String token = null;
        ResultSet result;
        Database db = new Database();
        result = db.executePreparedQuery(query, params);
        if (result.next()) {
            token = result.getString("token");
        }

        return token;
    }

    public static boolean checkToken(String token) throws SQLException {
        String query = "SELECT username FROM users WHERE token = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(token);

        String username = null;
        Database db = new Database();
        ResultSet result = db.executePreparedQuery(query, params);

        if (result.next()) {
            username = result.getString("username");
        }

        return username != null && username != "";
    }

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}
