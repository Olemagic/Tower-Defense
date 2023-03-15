import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class monsterBullet extends Bullets {
    private int timeAlive;
    
    public monsterBullet(int rotation, int pDamage) {
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
    }
}
