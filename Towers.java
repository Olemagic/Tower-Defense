import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Towers extends Actor {
    protected int range = 300;
    protected int reloadTime = 50;
    protected int damage = 2;
    protected int timeSinceLastShot = 1000;
    
    public Enemy getFurthestEnemyInRange(int range) {
        List<Enemy> enemiesInRange = getObjectsInRange(range, Enemy.class);
        if(enemiesInRange.isEmpty()) {
            return null;
        }
        
        int numberOfEnemiesLeft = 0;
        for (int i = 0; i < enemiesInRange.size(); i++) {
            Enemy currentEnemy = enemiesInRange.get(i);
            int rotation = getRotationToTarget(currentEnemy);
            if (hasLineOfSight(currentEnemy, rotation)) {
                enemiesInRange.remove(i);
                i--;
            }
            else {
                numberOfEnemiesLeft++;
            }
        }
        
        if (numberOfEnemiesLeft == 0) {
            return null;
        }
        Enemy[] enemiesWithLOS = new Enemy[numberOfEnemiesLeft];
        
        int j = 0;
        for (int i = 0; i < enemiesInRange.size(); i++) {
            if (enemiesInRange.get(i) != null) {
                enemiesWithLOS[j] = enemiesInRange.get(i);
                j++;
            }
        }
        
        
        int max = enemiesWithLOS[0].getDistanceMoved();
        Enemy farthestEnemy = enemiesWithLOS[0];
        for (int i = 1; i < enemiesWithLOS.length; i++) {
            int currentEnemyDistanceMoved = enemiesWithLOS[i].getDistanceMoved();
            if(max < currentEnemyDistanceMoved) {
                max = currentEnemyDistanceMoved;
                farthestEnemy = enemiesWithLOS[i];
            }
        }
        
        return farthestEnemy;
    }
    
    public int getRotationToTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        return rotation;
    }
    
    public boolean hasLineOfSight(Enemy enemy, int rotation) {
        boolean foundObstacle = false;
        LineOfSightBullet LOSchecker = new LineOfSightBullet(rotation);
        getWorld().addObject(LOSchecker, getX(), getY());
        
        while (!foundObstacle) {
            LOSchecker.move(1);
            if (LOSchecker.checkEnemy(enemy)) {
                return false;
            }
            
            if (LOSchecker.checkObstacle()){
                foundObstacle = true; //should just return true but we need a while loop...
            }
        }
        
        return foundObstacle;
    }
}
