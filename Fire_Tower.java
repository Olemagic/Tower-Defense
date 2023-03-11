import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fire_Tower extends Towers {
    private int range = 300;
    private int reloadTime = 50;
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
        int rotation = getRotationToTarget(target);
        getWorld().addObject(new monsterBullet(rotation), getX(), getY());
        
        timeSinceLastShot = 0;
    }
}
