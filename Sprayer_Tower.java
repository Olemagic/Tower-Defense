/**
 * Dritter Turm, schießt viele Projektile ohne Zielsuche
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Sprayer_Tower extends Towers {
    /**
     * Constructor für Sprayer_Tower:<br>
     * -Setzt Range, Nachladezeit und Schaden
     */
    public Sprayer_Tower() {
        //config
        range = 200;
        reloadTime = 100;
        damage = 1;
    }
    
    /**
     * Act-Methode von Sprayer_Tower:<br>
     * -Implementiert Nachladezeit<br>
     * -Schießt, wenn ein Gegner vorhanden ist und geschossen werden kann
     */
    public void act() {
        timeSinceLastShot++;
        if(timeSinceLastShot>=reloadTime && !getObjectsInRange(range, Enemy.class).isEmpty()) {
            shoot();
        }
    }
    
    /**
     * Schießt 8 Tack_Bullets mit einem Abstand von 45°
     */
    public void shoot() {
        for(int i=0; i<8; i++) {
            getWorld().addObject(new Tack_Bullet(i*45, damage), getX(), getY());
        }
        
        timeSinceLastShot = 0;
    }
}
