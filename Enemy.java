import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor {
    private int distanceMoved;
    
    public int getDistanceMoved() {
        return distanceMoved;
    }
    
    public void findNextPath() {
        int rotation = getRotation();
        
        if (rotation == 0) {
            if (getOneObjectAtOffset(100, 0, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
            }
            return;
        }
        
        if (rotation == 90) {
            if (getOneObjectAtOffset(0, 100, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
            }
            return;
        }
        
        if (rotation == 180) {
            if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
            }
            return;
        }
        
        if (rotation == 270) {
            if (getOneObjectAtOffset(0, -100, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
            }
            return;
        }
    }
}
