import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower_Footprint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower_Footprint extends GUI
{
    public Tower_Footprint(int size) {
        GreenfootImage image = new GreenfootImage(size, size);
        setImage(image);
    }
    
    public boolean isNotColliding() {
        if(getOneIntersectingObject(Tower_Menu_Placeholder.class)==null
            && getOneIntersectingObject(Path.class)==null
            && getOneIntersectingObject(Towers.class)==null
            && getOneIntersectingObject(Obstacle.class)==null) {
                return true;
            }
        return false;
    }
}
