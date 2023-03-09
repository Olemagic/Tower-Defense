import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends Actor {
    public Towers() {
        
    }
    
    /**
     * Act - do whatever the Towers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
    }
    
    public void getTarget(int range) {
        List<Monster> enemiesInRange = getObjectsInRange(range, Monster.class);
        if(enemiesInRange.size()==0) {
            return;
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
        aimAtTarget(farthestEnemy);
    }
    
    public void aimAtTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        double rotation = Math.atan2(distanceY, distanceX) * 180 / Math.PI;
        setRotation((int) rotation);
    }
}
