import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Das normale Bullet
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Shuriken extends Bullets {
    private int rotation;
    private int desiredRotation;
    private Enemy target;
    
    /**
     * Constructor für monsterBullet:<br>
     * -Legt die Rotation, den Schaden und Pierce fest<br>
     * -Deklariert die Länge des Arrays hitEnemies
     * @param rotation  Rotation des Bullets
     * @param pDamage   Schaden, den das Bullet an Gegnern macht
     */
    public Shuriken(int pRotation, int pDamage) {
        rotation = pRotation;
        setRotation(pRotation);
        damage = pDamage;
        pierce = 3;
        hitEnemies = new Enemy[pierce];
    }
    
    public void act() {
        if(pierce == 3) {
            target = getFurthestEnemy();
            if(target != null) {
                desiredRotation = getRotationToTarget(target);
            }
        }
        else {
            target = getNearestEnemy();
            if(target != null) {
                desiredRotation = getRotationToTarget(target);
            }
        }
        if(target !=null) {
            rotation = desiredRotation;
            setRotation(rotation);
        }
        super.act();
    }
    
    public double getDistance(Actor actor) {
        return Math.hypot(actor.getX() - getX(), actor.getY() - getY());
    }
    
    public Enemy getFurthestEnemy() {
        List<Enemy> enemiesInRange = getObjectsInRange(10000, Enemy.class);
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
    
    public Enemy getNearestEnemy() {
        List<Enemy> nearEnemies = getObjectsInRange(10000, Enemy.class);
        Enemy nearestEnemy = null;
        boolean progress = true;
        double nearestDistance = 10000;
        double distance;
        for (int i = 0; i < nearEnemies.size(); i++) {
            for (int j = 0; j<hitEnemies.length; j++) {
                if(hitEnemies[j] == nearEnemies.get(i)) {
                    progress = false;
                }
            }
            if(progress) {
                    distance = getDistance(nearEnemies.get(i));
                    if (distance < nearestDistance && hasLineOfSight(nearEnemies.get(i))) {
                        nearestEnemy = nearEnemies.get(i);
                        nearestDistance = distance;
                    }
            }
            progress = true;
        }
        return nearestEnemy;
    }
    
    /**
     * Gibt die Rotation zu einem Gegner zurück
     * @param target    Gegner, für den die Rotation berechnet werden soll
     * @return Rotation zum Gegner
     */
    public int getRotationToTarget(Enemy target) {
        int distanceX = target.getX() - getX();
        int distanceY = target.getY() - getY();
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        return rotation;
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
