/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.JsonObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dániel
 */
@XmlRootElement
public class AnswerObject {
    @XmlElement public int id;
    @XmlElement public String text;
    @XmlElement public int correct;
    @XmlElement public String pair;
}
