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
        int max = 0;
        Enemy farthestEnemy = null;
        for (int i = 0; i < enemiesInRange.size(); i++) {
            int currentEnemyDistanceMoved = enemiesInRange.get(i).getDistanceMoved();
            if(max < currentEnemyDistanceMoved) {
                if(hasLineOfSight(enemiesInRange.get(i))) {
                    max = currentEnemyDistanceMoved;
                    farthestEnemy = enemiesInRange.get(i);
                }
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
    
    public boolean hasLineOfSight(Enemy enemy) {
        Ray ray = new Ray(enemy, this);
        getWorld().addObject(ray, 0, 0);
        boolean hasLOS = ray.HasLOS();
        getWorld().removeObject(ray);
        return hasLOS;
    }
}
