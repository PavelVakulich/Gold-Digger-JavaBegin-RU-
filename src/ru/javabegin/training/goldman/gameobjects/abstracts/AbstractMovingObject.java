package ru.javabegin.training.goldman.gameobjects.abstracts;

import java.util.EnumMap;
import javax.swing.ImageIcon;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;
import ru.javabegin.training.goldman.gameobjects.interfaces.MovingObject;


public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {

    private int step = 1;
    
    protected EnumMap<MovingDirection, ImageIcon> movingImages = new EnumMap<>(MovingDirection.class);// карта иконок для всех направлений

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    protected void actionBeforeMove(MovingDirection direction) {

        changeIcon(direction);


    }

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        actionBeforeMove(direction);
        return doAction(gameObject);
    }

    public ActionResult doAction(AbstractGameObject gameObject) {

        if (gameObject == null) {
            return ActionResult.NO_ACTION;
        }

        switch (gameObject.getType()) {

            case NOTHING: {
                return ActionResult.MOVE;
            }

            case WALL: {
                return ActionResult.NO_ACTION;
            }
        }

        return ActionResult.NO_ACTION;
    }

   
    
    public Coordinate getDirectionCoordinate(MovingDirection direction) {

        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {
            case UP: {
                newCoordinate.setY(y - this.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + this.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - this.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + this.getStep());
                break;
            }
        }

        return newCoordinate;


    }
    

    public void changeIcon(MovingDirection direction) {
        super.setIcon(movingImages.get(direction));        
    }
    
  
}
