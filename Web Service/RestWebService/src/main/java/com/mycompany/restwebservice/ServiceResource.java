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
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuestionAndAnswer() throws SQLException {
        //TODO return proper representation object
        //return "<message></message>";
       Queries queries = new Queries();
       
       return queries.QuestionAndAnswer();
    }

    /**
     * PUT method for updating or creating an instance of ServiceResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getToken(JsonObject request) throws SQLException{
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
