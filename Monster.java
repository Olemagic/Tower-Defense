import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Enemy
{
    private int i = 1;
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (i == 1) {findNextPath();}
        move(10);
        Greenfoot.delay(1);
        i++;
        if (i == 10) {i = 0;}
    }
}
