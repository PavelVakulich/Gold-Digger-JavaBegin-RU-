package ru.javabegin.training.goldman.enums;

import java.io.Serializable;

public enum GameObjectType implements Serializable{

    TREE(6),
    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDMAN(1),    
    NOTHING(-1);

    private GameObjectType(int indexPriority) {
        this.indexPriority = indexPriority;
    }
    
    private int indexPriority;

    public int getIndexPriority() {
        return indexPriority;
    }
    
}
