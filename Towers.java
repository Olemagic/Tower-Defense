import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Towers extends Actor {
    public int[] getRotationToTarget(int range) {
        List<Enemy> enemiesInRange = getObjectsInRange(range, Enemy.class);
        if(enemiesInRange.isEmpty()) {
            int[] a = {0, 0};
            return a;
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
        
        int rotation = aimAtTarget(farthestEnemy);
        int[] a = {1, rotation};
        return a;
    }
    
    public int aimAtTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        return rotation;
    }
}
