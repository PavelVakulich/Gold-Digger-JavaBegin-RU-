package ru.javabegin.training.goldman.collections.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import ru.javabegin.training.goldman.collections.abstracts.MapMoveListenersRegistrator;
import ru.javabegin.training.goldman.enums.ActionResult;
import static ru.javabegin.training.goldman.enums.ActionResult.COLLECT_TREASURE;
import static ru.javabegin.training.goldman.enums.ActionResult.DIE;
import static ru.javabegin.training.goldman.enums.ActionResult.HIDE_IN_TREE;
import static ru.javabegin.training.goldman.enums.ActionResult.MOVE;
import static ru.javabegin.training.goldman.enums.ActionResult.WIN;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractMovingObject;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;
import ru.javabegin.training.goldman.gameobjects.impl.GoldMan;
import ru.javabegin.training.goldman.gameobjects.impl.Nothing;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultListener;
import ru.javabegin.training.goldman.movestrategies.interfaces.MoveStrategy;

public class MapCollection extends MapMoveListenersRegistrator implements Serializable {

    private HashMap<Coordinate, ArrayList<AbstractGameObject>> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);

    public MapCollection() {
    }

    @Override
    public List<AbstractGameObject> getAllGameObjects() {

        ArrayList<AbstractGameObject> list = new ArrayList<>();

        for (List<AbstractGameObject> tmpList : gameObjects.values()) {
            for (AbstractGameObject obj : tmpList) {
                list.add(obj);
            }
        }

        return list;
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {

        AbstractGameObject gameObject = null;

        ArrayList<AbstractGameObject> list = gameObjects.get(coordinate);

        if (list == null) {
            return null;
        }

        for (AbstractGameObject obj : list) {
            if (gameObject == null) {
                gameObject = obj;
                continue;
            }
            if (obj.getType().getIndexPriority() > gameObject.getType().getIndexPriority()) {
                gameObject = obj;
            }
        }


        return gameObject;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return getObjectByCoordinate(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> typeList = typeObjects.get(gameObject.getType());
        ArrayList<AbstractGameObject> objList = gameObjects.get(gameObject.getCoordinate());

        if (typeList == null) {
            typeList = new ArrayList<>();
        }

        if (objList == null) {
            objList = new ArrayList<>();
        }

        typeList.add(gameObject);
        objList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), objList);
        typeObjects.put(gameObject.getType(), typeList);

    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);
    }

    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);
    }

    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy) {
        GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;

        if (this.getGameObjects(gameObjectType) == null) {
            return;
        }

        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                if (moveStrategy != null) {
                    direction = moveStrategy.getDirection(movingObject, goldMan, this);
                }

                Coordinate newCoordinate = movingObject.getDirectionCoordinate(direction);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);

                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        Nothing nothing = new Nothing(newCoordinate);
                        swapObjects(movingObject, nothing);
                        removeObject(objectInNewCoordinate);
                        objectInNewCoordinate = nothing;
                        break;
                    }
                    case HIDE_IN_TREE: {
                        Nothing nothing = new Nothing(newCoordinate);
                        swapObjects(movingObject, nothing);
                        objectInNewCoordinate = nothing;
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }

                if (actionResult != ActionResult.NO_ACTION) {
                    notifyMoveListeners(actionResult, movingObject, objectInNewCoordinate);
                }

            }


        }
    }

    private void removeObject(AbstractGameObject obj) {
        gameObjects.get(obj.getCoordinate()).remove(obj);
        typeObjects.get(obj.getType()).remove(obj);
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        gameObjects.get(obj1.getCoordinate()).remove(obj1);
        gameObjects.get(obj2.getCoordinate()).remove(obj2);

        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);

        gameObjects.get(obj1.getCoordinate()).add(obj1);
        gameObjects.get(obj2.getCoordinate()).add(obj2);
    }

    @Override
    public void notifyMoveListeners(ActionResult actionResult, AbstractGameObject movingObject, AbstractGameObject targetObject) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, movingObject, targetObject);
        }
    }

    @Override
    public void clear() {
        gameObjects.clear();
        typeObjects.clear();
    }
}
