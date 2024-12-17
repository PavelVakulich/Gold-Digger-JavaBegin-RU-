package ru.javabegin.training.goldman.gamemap.abstracts;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.javabegin.training.goldman.collections.interfaces.GameCollection;
import ru.javabegin.training.goldman.gamemap.interfaces.TimeMap;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.objects.MapInfo;

public abstract class AbstractGameMap implements TimeMap, Serializable {

    private static final long serialVersionUID = 1L;
    protected GameCollection gameCollection;
    protected MapInfo mapInfo = new MapInfo();

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    @Override
    public MapInfo getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(MapInfo mapInfo) {
        this.mapInfo = mapInfo;
    }

   

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject;
    }

    @Override
    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

  
    
}
