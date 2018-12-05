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
 * @author Dávid / Marcell
 */
public class ScoreOject {
    
     //ezt csináltuk
    @XmlElement
    public String username;
    @XmlElement
    public int score;
    @XmlElement
    public String task;
    
}
