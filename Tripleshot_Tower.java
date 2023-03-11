import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tripleshot_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tripleshot_Tower extends Towers
{
    private int range = 300;
    private int reloadTime = 50;
    private int timeSinceLastShot = 1000;
    private double[] targetData;
    /**
     * Act - do whatever the Tripleshot_Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        timeSinceLastShot++;
        targetData = getTarget(range);
        if(targetData[0] == 1 && timeSinceLastShot>=reloadTime) {
            setRotation((int) targetData[1]);
            shoot(targetData[1]);
            timeSinceLastShot = 0;
        }
    }
    
    public void shoot(double rotation) {
        getWorld().addObject(new monsterBullet(rotation), this.getX(), this.getY());
        getWorld().addObject(new monsterBullet(rotation+10), this.getX(), this.getY());
        getWorld().addObject(new monsterBullet(rotation-10), this.getX(), this.getY());
    }
}
