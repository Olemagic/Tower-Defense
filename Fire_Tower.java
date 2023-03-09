import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire_Tower extends Towers {
    private int range;
    
    public Fire_Tower(int pRange) {
        range=pRange;
    }
    
    /**
     * Act - do whatever the FireTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        getTarget(range);
    }
}
