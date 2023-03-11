import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fire_Tower extends Towers {
    private int range = 300;
    private int reloadTime = 50;
    private int timeSinceLastShot = 1000;
    private int[] targetData;
    private monsterBullet newBullet;
    
    public void act() {
        timeSinceLastShot++;
        targetData = getRotationToTarget(range);
        if(targetData[0] == 1 && timeSinceLastShot>=reloadTime) {
            setRotation(targetData[1]);
            shoot(targetData[1]);
            timeSinceLastShot = 0;
        }
    }
    
    public void shoot(int rotation) {
        newBullet= new monsterBullet(rotation);
        getWorld().addObject(newBullet, getX(), getY());
    }
}
