import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sprayer_Tower extends Towers {
    public Sprayer_Tower() {
        //config
        range = 200;
        reloadTime = 100;
        damage = 1;
    }
    
    public void act() {
        timeSinceLastShot++;
        if(timeSinceLastShot>=reloadTime && !getObjectsInRange(range, Enemy.class).isEmpty()) {
            shoot();
        }
    }
    
    public void shoot() {
        for(int i=0; i<8; i++) {
            getWorld().addObject(new Tack_Bullet(i*45, damage), getX(), getY());
        }
        
        timeSinceLastShot = 0;
    }
}
