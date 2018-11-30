/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restwebservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.JsonObjects.AnswerObject;
import com.mycompany.JsonObjects.QuestionObject;
import com.mycompany.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 *
 * @author Dániel
 */
public class Queries {

    public static String QuestionAndAnswer(int taskId) throws SQLException {

        Database db = new Database();
        ObjectMapper mapper = new ObjectMapper();
        String query = "SELECT * FROM questions WHERE task_id = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(String.valueOf(taskId));

        ResultSet result = db.executePreparedQuery(query, params);
        ArrayList<QuestionObject> questions = new ArrayList<QuestionObject>();

        while (result.next()) {
            QuestionObject temp = new QuestionObject();
            temp.id = parseInt(result.getString("id"));
            temp.text = result.getString("question");
            questions.add(temp);
        }

        for (int i = 0; i < questions.size(); i++) {
            query = "SELECT * FROM answers WHERE question_id = ?";
            params.clear();
            params.add(String.valueOf(questions.get(i).id));
            result = db.executePreparedQuery(query, params);

            while (result.next()) {
                AnswerObject answerObject = new AnswerObject();
                answerObject.id = parseInt(result.getString("id"));
                answerObject.text = result.getString("answer");
                answerObject.correct = parseInt(result.getString("correct"));

                questions.get(i).answers.add(answerObject);
            }
        }

        String json = "";
        try {
            json = mapper.writeValueAsString(questions);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }

        return json;
    }
}
