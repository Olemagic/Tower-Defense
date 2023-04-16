/**
 * schießt einzelne, zielsuchende Projektile
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Ninja_Tower extends Towers {
    /**
     * Constructor für Ninja_Tower:<br>
     * -Setzt Range, Nachladezeit und Schaden
     */
    public Ninja_Tower() {
        //config
        range = 400;
        reloadTime = 100;
        damage = 1;
    }
    
    /**
     * Act-Methode von Ninja_Tower:<br>
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
     * Dreht sich zum Gegner und spawnt einen Shuriken
     * @param target    Gegner, auf den geschossen wird
     */
    public void shoot(Enemy target) {
        int rotation = getRotationToTarget(target);
        
        setRotation(rotation);
        getWorld().addObject(new Shuriken(rotation, damage), getX(), getY());
        
        timeSinceLastShot = 0;
    }
}
