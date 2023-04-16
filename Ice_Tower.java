import java.util.List;

/**
 * Turm, der Gegner einfriert
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Ice_Tower extends Towers
{
    /**
     * Constructor für Ice_Tower:<br>
     * -Setzt Range, Nachladezeit und Schaden
     */
    public Ice_Tower() {
        //config
        range = 200;
        reloadTime = 600;
        damage = 0;
    }
    
    /**
     * Act-Methode von Fire_Tower:<br>
     * -Implementiert Nachladezeit<br>
     * -Schießt, wenn ein Gegner vorhanden ist und geschossen werden kann
     */
    public void act() {
        timeSinceLastShot++;
        
        if(getObjectsInRange(range, Enemy.class) == null) {return;}
        if(timeSinceLastShot>=reloadTime) {
            shoot();
        }
    }
    
    /**
     * Friert alle Gegner in der Reichweite ein
     */
    public void shoot() {
        List<Enemy> enemiesInRange = getObjectsInRange(range, Enemy.class);
        for(Enemy enemy : enemiesInRange) {
            enemy.freeze();
        }
        timeSinceLastShot = 0;
    }
}
