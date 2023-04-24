/**
 * Das Bullet vom Sprayer-Turm
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Tack_Bullet extends Bullets {
    private int timeAlive = 0; //Zähler, wie weit das Bullet geflogen ist
    
    /**
     * Constructor für Tack_Bullet:<br>
     * -Legt die Rotation, den Schaden und Pierce fest<br>
     * -Deklariert die Länge des Arrays hitEnemies
     * @param rotation Rotation des Bullets
     * @param pDamage Schaden, den das Bullet an Gegnern macht
     */
    public Tack_Bullet(int rotation, int pDamage) {
        setRotation(rotation);
        damage = pDamage;
        pierce = 3; //config; 1: disabled
        hitEnemies = new Enemy[pierce];
    }
    
    /**
     * Act-Methode von Tack_Bullet: Ruft die Act-Methode von Bullets auf, erhöht den Zähler für die zurückgelegte Entfernung und entfernt das Bullet, wenn es zu lange lebt.
     */
    public void act() {
        super.act();
        timeAlive++;
        int lifespan = 60; //Anzahl der Acts, die das Bullet leben darf
        if(timeAlive >= lifespan) {
            getWorld().removeObject(this);
        }
    }
}
