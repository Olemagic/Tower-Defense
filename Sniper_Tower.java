import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sniper_Tower extends Towers
{
    private int range = 2000;
    private int reloadTime = 150;
    private int damage = 3;
    private int timeSinceLastShot = 1000;
    
    public void act() {
        timeSinceLastShot++;
        if(timeSinceLastShot>=reloadTime) {
            Enemy target = getFurthestEnemyInRange(range);
            
            if (target == null) {return;}
            
            setRotation(getRotationToTarget(target));
            shoot(target);
        }
    }
    
    public void shoot(Enemy target) {
        target.removeHealth(damage);
        timeSinceLastShot = 0;
    }
}
