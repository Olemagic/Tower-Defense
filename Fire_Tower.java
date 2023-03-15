import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fire_Tower extends Towers {    
    public Fire_Tower() {
        //config
        range = 300;
        reloadTime = 50;
        damage = 2;
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
        int rotation = getRotationToTarget(target);
        getWorld().addObject(new monsterBullet(rotation, damage), getX(), getY());
        
        timeSinceLastShot = 0;
    }
}
