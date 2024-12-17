package ru.javabegin.training.goldman.gameobjects.impl;

import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;

public class Treasure extends AbstractGameObject {

    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.saveIcon("/ru/javabegin/training/goldman/images/gold.png");
    }
    
    
    private int score = 5;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
