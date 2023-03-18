import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tripleshot_Tower extends Towers {
    public Tripleshot_Tower() {
        //config
        range = 300;
        reloadTime = 1;
        damage = 1;
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
        getWorld().addObject(new monsterBullet(rotation+10, damage), getX(), getY());
        getWorld().addObject(new monsterBullet(rotation-10, damage), getX(), getY());
        
        timeSinceLastShot = 0;
    }
}
