import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Das normale Bullet
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class monsterBullet extends Bullets {
    /**
     * Constructor für monsterBullet:<br>
     * -Legt die Rotation, den Schaden und Pierce fest<br>
     * -Deklariert die Länge des Arrays hitEnemies
     * @param rotation  Rotation des Bullets
     * @param pDamage   Schaden, den das Bullet an Gegnern macht
     */
    public monsterBullet(int rotation, int pDamage) {
        setRotation(rotation);
        damage = pDamage;
        pierce = 3;
        hitEnemies = new Enemy[pierce];
    }
}
