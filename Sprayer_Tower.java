import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sprayer_Tower extends Towers
{
    private int range = 200;
    private int reloadTime = 100;
    private int timeSinceLastShot = 1000;
    
    public void act() {
        timeSinceLastShot++;
        if(timeSinceLastShot>=reloadTime && !getObjectsInRange(range, Enemy.class).isEmpty()) {
            shoot();
        }
    }
    
    public void shoot() {
        for(int i=0; i<8; i++) {
            getWorld().addObject(new Tack_Bullet(i*45), getX(), getY());
        }
        
        timeSinceLastShot = 0;
    }
}
