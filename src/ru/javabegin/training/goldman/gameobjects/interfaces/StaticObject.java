/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.goldman.gameobjects.interfaces;

import javax.swing.ImageIcon;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;


public interface StaticObject {
 

    ImageIcon getIcon();


    Coordinate getCoordinate();


    GameObjectType getType();
    
            
}
