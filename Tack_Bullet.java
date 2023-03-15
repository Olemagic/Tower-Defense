import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tack_Bullet extends Bullets {
    //config
    private int lifespan = 300;
    
    private int timeAlive = 0;
    
    public Tack_Bullet(int rotation, int pDamage) {
        setRotation(rotation);
        damage = pDamage;
    }
    
    public void act() {
        timeAlive += 5;
        move(5);
        if(isTouching(Enemy.class)) {
            Enemy hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            hitEnemy.removeHealth(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()) {
            getWorld().removeObject(this);
        }
        else if(timeAlive >= lifespan) {
            getWorld().removeObject(this);
        }
    }
}
