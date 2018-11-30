/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.JsonObjects;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dániel
 */
@XmlRootElement
public class QuestionObject {
    @XmlElement public int id;
    @XmlElement public String text;
    @XmlElement public ArrayList<AnswerObject> answers;
    
    public QuestionObject(){
        answers = new ArrayList<AnswerObject>();
    }
}
