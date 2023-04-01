import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Finishobjekt, überprüft, ob ein Gegner am Ziel ist
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Finish extends Actor {
    /**
     * Act-Methode von Finish:<br>
     * -Sammelt alle Gegner, die das Objekt berühren in einer Liste<br>
     * -Überprüft für jeden Gegner, ob er am Rand der Welt ist und entfernt ihn
     */
    public void act() {
        List<Enemy> enemies = getIntersectingObjects(Enemy.class);
        for (Enemy enemy : enemies) {
            if (!enemy.isAtEdge()) {return;}
            
            int damage = enemy.getDamage();
            Level world = (Level) getWorld();
            world.removeHealth(damage);
            world.removeObject(enemy);
        }
    }
}
