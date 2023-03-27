import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Das normale Bullet
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Shuriken extends Bullets {
    private Enemy target; //Target
    
    /**
     * Constructor für Shuriken:<br>
     * -Legt die Rotation, den Schaden und Pierce fest<br>
     * -Deklariert die Länge des Arrays hitEnemies
     * @param rotation  Rotation des Bullets
     * @param pDamage   Schaden, den das Bullet an Gegnern macht
     */
    public Shuriken(int pRotation, int pDamage) {
        setRotation(pRotation);
        damage = pDamage;
        pierce = 3;
        hitEnemies = new Enemy[pierce];
    }
    
    /**
     * Act-Methode von Shuriken(Dreht sich zum Gegner):<br>
     * -Erster Gegner: am weitesten gelaufen<br>
     * -Danach: am nächsten von der aktuellen Position
     */
    public void act() {
        if(pierce == 3) {
            target = getFurthestEnemy();
            if(target != null) {
                setRotation(getRotationToTarget(target));
            }
        }
        else {
            target = getNearestEnemy();
            if(target != null) {
                setRotation(getRotationToTarget(target));
            }
        }
        super.act();
    }
    
    /**
     * Gibt die Distanz zwischen einem Gegner und dem Shuriken zurück
     * @param target    Der Gegner
     * @return Die Entfernung
     */
    public double getDistance(Enemy target) {
        return Math.hypot(target.getX() - getX(), target.getY() - getY());
    }
    
    /**
     * Gibt den am weitesten gelaufenen Gegner in der angegebenen Reichweite zurück
     * @see Towers#getFurthestEnemyInRange(int)
     * @param range Suchradius
     * @return am weitesten gelaufener Gegner
     */
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
    
    /**
     * Gibt den nächstliegenden Gegner zurück
     * @return nächstliegender Gegner
     */
    public Enemy getNearestEnemy() {
        List<Enemy> nearEnemies = getObjectsInRange(2000, Enemy.class);
        Enemy nearestEnemy = null;
        boolean progress = true;
        double nearestDistance = 2000;
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
