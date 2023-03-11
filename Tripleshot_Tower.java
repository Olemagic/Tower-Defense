import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tripleshot_Tower extends Towers
{
    private int range = 300;
    private int reloadTime = 50;
    private int timeSinceLastShot = 1000;
    private int[] targetData;
    
    public void act() {
        timeSinceLastShot++;
        targetData = getRotationToTarget(range);
        if(targetData[0] == 1 && timeSinceLastShot>=reloadTime) {
            setRotation((int) targetData[1]);
            shoot(targetData[1]);
            timeSinceLastShot = 0;
        }
    }
    
    public void shoot(int rotation) {
        getWorld().addObject(new monsterBullet(rotation), getX(), getY());
        getWorld().addObject(new monsterBullet(rotation+10), getX(), getY());
        getWorld().addObject(new monsterBullet(rotation-10), getX(), getY());
    }
}
