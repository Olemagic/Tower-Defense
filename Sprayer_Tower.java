import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sprayer_Tower extends Towers
{
    private int range = 200;
    private int reloadTime = 100;
    private int timeSinceLastShot = 1000;
    private int[] targetData;
    
    public void act() {
        timeSinceLastShot++;
        targetData = getRotationToTarget(range);
        if(targetData[0] == 1 && timeSinceLastShot>=reloadTime) {
            shoot();
            timeSinceLastShot = 0;
        }
    }
    
    public void shoot() {
        for(int i=0; i<8; i++) {
            getWorld().addObject(new Tack_Bullet(i*45), getX(), getY());
        }
    }
}
