import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Ray extends Actor
{
    private Enemy enemy;
    private Towers tower;
    
    public Ray(Enemy pEnemy, Towers pTower) {
        enemy = pEnemy;
        tower = pTower;
    }
    
    public boolean HasLOS() {
        boolean hasLOS = false;
        int towerX = tower.getX();
        int towerY = tower.getY();
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        
        int distanceX = enemyX-towerX;
        int distanceY = enemyY-towerY;
        int distance = (int) Math.hypot(distanceX, distanceY);
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        
        setLocation(distanceX/2+towerX, distanceY/2+towerY);
        createImage(distance);
        setRotation(rotation);
        if(getOneIntersectingObject(Obstacle.class) == null) {
            hasLOS = true;
        }
        return hasLOS;
    }
    
    public void createImage(int distance) {
        setImage(new GreenfootImage(distance, 50));
    }
}
