import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sniper_Tower extends Towers {
    public Sniper_Tower() {
        //config
        range = 2000;
        reloadTime = 150;
        damage = 3;
    }
    
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
        target.isDead();
        timeSinceLastShot = 0;
    }
}
