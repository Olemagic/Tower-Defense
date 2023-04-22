/**
 * Zweiter Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Tank extends Enemy {
    /**
     * Constructor für Tank:<br>
     * -Setzt Leben, Schaden, Geschwindigkeit, Todesgeld und Namen
     */
    public Tank() {
        //config
        health = 10;
        damage = 5;
        moneyOnDeath = 20;
        speed = 1;
        enemyName = "Enemy-2";
    }
}
