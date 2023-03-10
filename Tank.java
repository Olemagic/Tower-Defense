import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank extends Enemy
{
    private int i = 1;
    private int health = 5;
    private int distanceMoved = 0;
    /**
     * Act - do whatever the Tank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        switch(i) {
            case 1: {findNextPath(); break;}
            case 100: {i = 0;}
        }
        move(1);
        distanceMoved+=1;
        i++;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void removeHealth(int damage) {
        health -= damage;
    }
    public int getDistanceMoved() {
        return distanceMoved;
    }
}
