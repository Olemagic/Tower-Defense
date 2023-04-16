/**
 * Zweiter Turm, schießt drei Projektile mit je 10° Abstand
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Tripleshot_Tower extends Towers {
    /**
     * Constructor für Tripleshot_Tower:<br>
     * -Setzt Range, Nachladezeit und Schaden
     */
    public Tripleshot_Tower() {
        //config
        range = 300;
        reloadTime = 50;
        damage = 1;
    }
    
    /**
     * Act-Methode von Tripleshot_Tower:<br>
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
     * Dreht sich zum Gegner und spawnt drei Bullets mit Abstand 10°
     * @param target    Gegner, auf den geschossen wird
     */
    public void shoot(Enemy target) {
        int rotation = getRotationToTarget(target);
        
        setRotation(rotation);
        getWorld().addObject(new monsterBullet(rotation, damage), getX(), getY());
        getWorld().addObject(new monsterBullet(rotation+10, damage), getX(), getY());
        getWorld().addObject(new monsterBullet(rotation-10, damage), getX(), getY());
        
        timeSinceLastShot = 0;
    }
}
