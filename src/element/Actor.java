package element;


import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

import display.World;
import interact.GameStage;


/**
 * Define the basic action for different actors
 * such as {@link AngryShark},{@link Boat}
 * {@link End},{@link Log},{@link Obstacle}
 * {@link Shark},{@link Turtle},{@link WetTurtle}.
 * <p>
 * @author scyyz4
 */
public abstract class Actor extends ImageView{

	
    /**
     * Control actor's movement.
     *
     * @param dx - the movement on the x-coordinate
     * @param dy - the movement on the y-coordinate
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the current world.
     *
     * @return the world
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Gets the intersecting objects.
     *
     * @param <A> the generic type
     * @param cls the cls
     * @return the intersecting objects
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
     * Manage input.
     *
     * @param e the inputed event
     */
    public void manageInput(InputEvent e) {
        
    }

    /**
     * Gets the one intersecting object.
     *
     * @param <A> the generic type
     * @param cls the cls
     * @return the one intersecting object
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
    
    


    /**
     * Abstract method,
     * the subclasses will override this method.
     * @param now the now
     */
    public abstract void act(long now);
    
    
    /**
     * Display different actors
     * with game level inputed.
     * @param gameLevel  - Game level
     * @param background - Current background
     */
    public void disPlay(String gameLevel,GameStage background) {  	
    }
    
    /**
     * Display actors without game level inputed.
     */
    public void disPlay() {}
    
    /**
     * Display actors with current background inputed.
     * @param bg - Current background
     */
    public void disPlay(GameStage bg) {}
}
