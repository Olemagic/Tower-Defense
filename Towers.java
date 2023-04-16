import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Parent-class aller Türme
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Towers extends Actor {
    protected int range; //Reichweite
    protected int reloadTime; //Nachladezeit
    protected int damage; //Schaden
    protected int timeSinceLastShot = 1000; //Zähler der Zeit, die verbracht wurde, ohne zu schießen
    
    /**
     * Gibt den am weitesten gelaufenen Gegner in der angegebenen Reichweite zurück
     * @param range Suchradius
     * @return am weitesten gelaufener Gegner
     */
    public Enemy getFurthestEnemyInRange(int range) {
        List<Enemy> enemiesInRange = getObjectsInRange(range, Enemy.class);
        if(enemiesInRange.isEmpty()) {
            return null;
        }
        int max = 0;
        Enemy farthestEnemy = null;
        for (Enemy enemy : enemiesInRange) {
            int currentEnemyDistanceMoved = enemy.getDistanceMoved();
            if(max < currentEnemyDistanceMoved) {
                if(hasLineOfSight(enemy)) {
                    max = currentEnemyDistanceMoved;
                    farthestEnemy = enemy;
                }
            }
        }
        
        return farthestEnemy;
    }
    
    /**
     * Gibt die Rotation zu einem Gegner zurück
     * @param target    Gegner, für den die Rotation berechnet werden soll
     * @return Rotation zum Gegner
     */
    public int getRotationToTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        return (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
    }
    
    /**
     * Überprüft, ob der Turm einen Gegner sehen kann
     * @see Ray#HasLOS()
     * @param enemy Gegner, für den überprüft wird
     * @return true, wenn kein Obstacle zwischen Turm und Gegner ist<br>
     * false, wenn ein Obstacle zwischen Turm und Gegner ist
     */
    public boolean hasLineOfSight(Enemy enemy) {
        Ray ray = new Ray(enemy, this);
        getWorld().addObject(ray, 0, 0);
        boolean hasLOS = ray.HasLOS();
        getWorld().removeObject(ray);
        return hasLOS;
    }
}
