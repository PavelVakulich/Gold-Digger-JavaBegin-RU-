package ru.javabegin.training.goldman.gameobjects.interfaces;

import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;

public interface MovingObject extends StaticObject{
    
    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject); 
    
    int getStep();
       
}
