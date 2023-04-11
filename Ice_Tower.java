import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Ice_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Dreht sich zum Gegner und spawnt ein Bullet
     * @param target    Gegner, auf den geschossen wird
     */
    public void shoot() {
        List<Enemy> enemiesInRange = getObjectsInRange(range, Enemy.class);
        for(Enemy enemy : enemiesInRange) {
            enemy.freeze();
        }
        timeSinceLastShot = 0;
    }
}
