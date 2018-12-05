/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restwebservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.JsonObjects.ResponseObject;
import com.mycompany.TokenController.TokenController;
import com.mycompany.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 * REST Web Service
 *
 * @author Dániel
 */
@Path("service")
public class ServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceResource
     */
    public ServiceResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.restwebservice.ServiceResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{task}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuestionAndAnswer(@PathParam("task") int taskId) throws SQLException {

        return Queries.getQuestionAndAnswer(taskId);
    }

    @GET
    @Path("tasks/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTasks() throws SQLException {
        return Queries.getTasks();
    }

    
    
    //azt csináltuk @author Dávid / Marcell
    @GET
    @Path("toplist/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getToplist()throws SQLException {
    
        return Queries.getToplist();
    }
    
    
    /**
     * PUT method for updating or creating an instance of ServiceResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String registerUser(JsonObject request) throws SQLException {
        String user = request.getString("username");
        String password = request.getString("password");
        String email = request.getString("email");
        String token = TokenController.generateToken();

        String query = "INSERT INTO users (username, password, email, token) VALUES (?,?,?,?)";
        ArrayList<String> params = new ArrayList<String>();
        params.add(user);
        params.add(password);
        params.add(email);
        params.add(token);
        Database db = new Database();
        int insertedId = db.executeInsertStatement(query, params);

        ResponseObject response = new ResponseObject();
        if (insertedId > 0) {
            response.status = 1;
            response.message = "Registered successful.";
        } else {
            response.status = 0;
            response.message = "Error.";
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }

        return json;
    }

    @Path("insert/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertResults(JsonObject request) throws SQLException {
        String token = request.getString("token");
        String json = "Error.";

        if (TokenController.checkToken(token)) {
            String userId = request.getString("user_id");
            String taskId = request.getString("task_id");
            int score = parseInt(request.getString("score"));
            json = Queries.insertResults(userId, taskId, score);
        }
        return json;
    }

    @Path("check/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getToken(JsonObject request) throws SQLException {
        String user = request.getString("user");
        String password = request.getString("password");
        String token = TokenController.getToken(user, password);

        ResponseObject response = new ResponseObject();
        if (token != null) {
            response.status = 1;
            response.message = token;
        } else {
            response.status = 0;
            response.message = "Error.";
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }

        return json;

    }

}
