import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class monsterBullet extends Bullets {
    //config
    private int damage = 2;
    
    private int timeAlive;
    
    public monsterBullet(int rotation) {
        setRotation(rotation);
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
    }
}
