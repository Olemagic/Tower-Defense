import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends Actor {
    public Towers() {
        
    }
    
    /**
     * Act - do whatever the Towers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
    }
    
    public void aimAtTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        
        double rotation = Math.atan2(distanceY, distanceX) * 180 / Math.PI;
        
        setRotation((int) rotation);
    }
}
