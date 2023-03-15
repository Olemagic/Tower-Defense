import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LineOfSightBullet extends Bullets {
    public void act() {} //is here so it doesnt inherit the act() method from the Bullets class
    
    public LineOfSightBullet(int rotation) {
        setRotation(rotation);
    }
    
    public boolean checkObstacle() {
        if (getOneIntersectingObject(Obstacle.class) != null) return true;
        else return false;
    }
    
    public boolean checkEnemy(Enemy enemy) {
        if (getOneIntersectingObject(Enemy.class) == enemy) return true;
        else return false;
    }
}
