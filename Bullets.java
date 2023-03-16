import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullets extends SmoothMover {
    protected int damage;
    protected int pierce;
    protected Enemy[] hitEnemies;
    protected int currentIndex = 0;
    public void act() {
        move(5);
        if(isTouching(Obstacle.class)) {
            getWorld().removeObject(this);
        }
        else if(isTouching(Enemy.class)) {
            Enemy hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            for(int i=0; i<hitEnemies.length; i++) {
                if(hitEnemies[i] == hitEnemy) {
                    return;
                }
            }
            hitEnemies[currentIndex]=hitEnemy;
            currentIndex++;
            hitEnemy.removeHealth(damage);
            pierce--;
            if(pierce==0) {
                getWorld().removeObject(this);
            }
        }
        else if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
