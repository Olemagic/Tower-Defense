import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Vierter Turm, schießt ohne Projektile und hat unendliche Reichweite
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Sniper_Tower extends Towers {
    /**
     * Constructor für Sniper_Tower:<br>
     * -Setzt Range, Nachladezeit und Schaden
     */
    public Sniper_Tower() {
        //config
        range = 2000;
        reloadTime = 150;
        damage = 3;
    }
    
    /**
     * Act-Methode von Sniper_Tower:<br>
     * -Implementiert Nachladezeit<br>
     * -Schießt, wenn ein Gegner vorhanden ist und geschossen werden kann
     */
    public void act() {
        timeSinceLastShot++;
        
        Enemy target = getFurthestEnemyInRange(range);
        if (target == null) {return;}
        
        if(timeSinceLastShot>=reloadTime) {
            shoot(target);
        }
    }
    
    /**
     * Dreht sich zum Gegner und schießt auf ihn
     * @param target    Gegner, auf den geschossen wird
     */
    public void shoot(Enemy target) {
        target.removeHealth(damage);
        target.isDead();
        timeSinceLastShot = 0;
    }
}
