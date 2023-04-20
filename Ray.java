import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Objekt, dass erstellt wird, um zu überprüfen, ob ein Turm einen Gegner sehen kann
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Ray extends Actor {
    private final Enemy enemy; //Der Gegner
    private final Actor actor; //Der Turm/Der Shuriken
    
    /**
     * Constructor von Ray:<br>
     * -Setzt den Gegner<br>
     * -Setzt den Turm
     * @param pEnemy Der Gegner, für den überprüft wird
     * @param pActor Der Turm/Shuriken, für den überprüft wird
     */
    public Ray(Enemy pEnemy, Actor pActor) {
        enemy = pEnemy;
        actor = pActor;
    }
    
    /**
     * Gibt zurück, ob der Turm/Shuriken den Gegner sehen kann<br>
     * Funktionsweise:<br>
     * -Berechnet die Länge des Rays (Entfernung zwischen Gegner und Turm/Shuriken)<br>
     * -Berechnet den Winkel in welchem die beiden zueinander sind über Arc-tan<br>
     * -Platziert den Ray in der Mitte und setzt die Rotation<br>
     * -Erstellt das Bild passender Länge<br>
     * -Überprüft, ob der Ray ein Obstacle berührt
     * @return true, wenn ein Obstacle zwischen Gegner und Turm/Shuriken sind<br>false, wenn kein Obstacle zwischen Gegner und Turm/Shuriken sind
     */
    public boolean HasLOS() {
        boolean hasLOS = false;
        int actorX = actor.getX();
        int actorY = actor.getY();
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        
        int distanceX = enemyX-actorX;
        int distanceY = enemyY-actorY;
        int distance = (int) Math.hypot(distanceX, distanceY);
        int rotation = (int) (Math.atan2(distanceY, distanceX) * 180 / Math.PI);
        
        if(distance==0) {
            return true;
        }
        
        setLocation(distanceX/2+actorX, distanceY/2+actorY);
        createImage(distance);
        setRotation(rotation);
        if(getOneIntersectingObject(Obstacle.class) == null) {
            hasLOS = true;
        }
        return hasLOS;
    }
    
    /**
     * Erstellt das Bild
     * @param distance Distanz zwischen Turm und Gegner/Länge des Bildes
     */
    public void createImage(int distance) {
        setImage(new GreenfootImage(distance, 50));
    }
}
