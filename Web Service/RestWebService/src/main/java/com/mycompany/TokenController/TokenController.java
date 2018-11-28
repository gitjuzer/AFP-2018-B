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
        params.add(sha1(password));

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


    private static String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (Exception e) {
        }
        return sha1;
    }
}
