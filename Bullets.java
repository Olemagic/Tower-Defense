import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Parent-class aller von Türmen geschossenen Projektile
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Bullets extends SmoothMover {
    protected int damage; //Schaden des Projektils
    protected int pierce; //Anzahl an Gegnern, die das Projektil treffen kann
    protected Enemy[] hitEnemies; //Bereits getroffene Gegner, damit Gegner nicht mehrmals getroffen werden
    protected int currentIndex = 0; //Zähler für das Array oben
    
    /**
     * Act-Methode von Bullets:<br>
     * -Bewegt das Bullet<br>
     * -Falls ein Obstacle berührt wird oder das Bullet am Rand der Welt ist, wird das Bullet entfernt(Wichtig wegen Tripleshottower)<br>
     * -Wenn ein Gegner berührt wird, wird diesem der Schaden des Bullets vom Leben abgezogen und er wird im Array gespeichert. Wenn pierce=0, wird das Bullet entfernt
     */
    public void act() {
        move(5);
        if(isTouching(Obstacle.class) || isAtEdge()) {
            getWorld().removeObject(this);
        }
        else if(isTouching(Enemy.class)) {
            Enemy hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            for(int i=0; i<hitEnemies.length; i++) {
                if(hitEnemies[i] == hitEnemy) {
                    return;
                }
            }
            hitEnemies[currentIndex]=hitEnemy;
            currentIndex++;
            hitEnemy.removeHealth(damage);
            pierce--;
            if(pierce==0) {
                getWorld().removeObject(this);
            }
        }
    }
    
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
