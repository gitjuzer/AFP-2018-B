/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restwebservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Marcell
 */
public class Queries {
    
    public String QuestionAndAnswer() throws SQLException{
        
        Database db=new Database();
        ObjectMapper mapper = new ObjectMapper();
        ResultSet result=db.executeQuery("SELECT question.id, questions.question, answers.answer FROM questions INNER JOIN answers ON (answers.question_id = questions.id);");
        
        LinkedList<ResultSet> ret = new LinkedList<ResultSet>();
        
        while(result.next()) {
            result.getInt("question.id");
            result.getString("questions.question");
            result.getString("answers.answer");
            
            ret.add(result);
        }
        String json = "";
        try {
            json = mapper.writeValueAsString(ret);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }
          
        return json;
    }
    
    
    
}
