import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor {
    protected int health;
    protected int damage;
    
    protected int distanceMoved;
    protected int numberOfActs = 51;
    
    public void removeHealth(int damage) {health -= damage;}
    
    public void isDead() {
        if (health <= 0) {
            ((Level) getWorld()).addMoney(20);
            getWorld().removeObject(this);
        }
    }
    
    public int getDamage() {return damage;}
    
    public int getDistanceMoved() {return distanceMoved;}
    
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
