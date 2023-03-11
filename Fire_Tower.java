import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire_Tower extends Towers {
    private int range = 300;
    private int reloadTime = 50;
    private int timeSinceLastShot = 1000;
    private double[] targetData;
    private monsterBullet newBullet;
    /**
     * Act - do whatever the FireTower wants to do. This method is called whenever
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
        newBullet= new monsterBullet(rotation);
        getWorld().addObject(newBullet, this.getX(), this.getY());
    }
}
