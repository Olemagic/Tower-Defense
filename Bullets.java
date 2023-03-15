import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullets extends SmoothMover {
    protected int damage;
    
    public void act() {
        move(5);
        if(isTouching(Enemy.class)) {
            Enemy hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            hitEnemy.removeHealth(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
