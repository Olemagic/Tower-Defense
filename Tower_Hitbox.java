import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower_Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower_Hitbox extends GUI
{
    public Tower_Hitbox(int size) {
        GreenfootImage image = new GreenfootImage(size, size);
        setImage(image);
    }
    
    public boolean isNotColliding() {
        return getOneIntersectingObject(Tower_Menu_Placeholder.class) == null
                && getOneIntersectingObject(Path.class) == null
                && getOneIntersectingObject(Towers.class) == null
                && getOneIntersectingObject(Obstacle.class) == null;
    }
}
