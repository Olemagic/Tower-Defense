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
        
        int max = enemiesInRange.get(0).getDistanceMoved();
        Enemy farthestEnemy = enemiesInRange.get(0);
        for(int i=1; i<enemiesInRange.size(); i++) {
            int currentEnemyDistanceMoved = enemiesInRange.get(i).getDistanceMoved();
            if(max<currentEnemyDistanceMoved) {
                max=currentEnemyDistanceMoved;
                farthestEnemy = enemiesInRange.get(i);
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
}
