import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sprayer_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sprayer_Tower extends Towers
{
    private int range = 200;
    private int reloadTime = 100;
    private int timeSinceLastShot = 1000;
    private double[] targetData;
    /**
     * Act - do whatever the Sprayer_Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        timeSinceLastShot++;
        targetData = getTarget(range);
        if(targetData[0] == 1 && timeSinceLastShot>=reloadTime) {
            shoot();
            timeSinceLastShot = 0;
        }
    }
    
    public void shoot() {
        for(int i=0; i<8; i++) {
            getWorld().addObject(new Tack_Bullet(i*45), this.getX(), this.getY());
        }
    }
}
