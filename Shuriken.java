import java.util.List;

/**
 * Bullet, dass Gegnern folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Shuriken extends Bullets {

    /**
     * Constructor für Shuriken:<br>
     * -Legt die Rotation, den Schaden und Pierce fest<br>
     * -Deklariert die Länge des Arrays hitEnemies
     * @param pRotation Rotation des Bullets
     * @param pDamage Schaden, den das Bullet an Gegnern macht
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
        //Target
        Enemy target;
        if(pierce == 3) {
            target = getFurthestEnemy();
        }
        else {
            target = getNearestEnemy();
        }
        if(target != null) {
            setRotation(getRotationToTarget(target));
        }
        super.act();
    }
    
    /**
     * Gibt die Distanz zwischen einem Gegner und dem Shuriken zurück
     * @param target Der Gegner
     * @return Die Entfernung
     */
    public double getDistance(Enemy target) {
        return Math.hypot(target.getX() - getX(), target.getY() - getY());
    }
    
    /**
     * Gibt den am weitesten gelaufenen Gegner zurück
     * @see Towers#getFurthestEnemyInRange(int)
     * @return am weitesten gelaufener Gegner
     */
    public Enemy getFurthestEnemy() {
        List<Enemy> enemiesInRange = getObjectsInRange(2000, Enemy.class);
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
     * Gibt den nächstliegenden Gegner zurück
     * @return nächstliegender Gegner
     */
    public Enemy getNearestEnemy() {
        List<Enemy> nearEnemies = getObjectsInRange(2000, Enemy.class);
        Enemy nearestEnemy = null;
        boolean progress = true;
        double nearestDistance = 2000;
        double distance;
        for (Enemy enemy : nearEnemies) {
            for (Enemy hitenemy : hitEnemies) {
                if (hitenemy == enemy) {
                    progress = false;
                    break;
                }
            }
            
            if(progress) {
                    distance = getDistance(enemy);
                    if (distance < nearestDistance && hasLineOfSight(enemy)) {
                        nearestEnemy = enemy;
                        nearestDistance = distance;
                    }
            }
            progress = true;
        }
        return nearestEnemy;
    }
}
