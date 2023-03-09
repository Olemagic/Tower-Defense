import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class for all enemies.
 * 
 * @author (your name) 
 * @version 0.1
 */
public class Enemies extends Actor {
    public void findNextPath() {
        int rotation = getRotation();
        System.out.println("findpath");
        
        if (rotation == 0) {
            if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
                moveSmoothly();
            }
        }
        
        if (rotation == 90) {
            if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
                moveSmoothly();
            }
        }
        
        if (rotation == 180) {
            if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
                moveSmoothly();
            }
        }
        
        if (rotation == 270) {
            if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
                moveSmoothly();
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
                moveSmoothly();
            }
        }
    }
    
    public void moveSmoothly() {
        for (int i = 0; i < 10; i++) {
            move(10);
            Greenfoot.delay(1);
            System.out.println("wait");
        }
    }
}
