/**
 * Dritter Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Speed extends Enemy {
    /**
     * Constructor für Speed:<br>
     * -Setzt Leben, Schaden, Geschwindigkeit, Todesgeld und Namen
     */
    public Speed() {
        //config
        health = 5;
        damage = 2;
        speed = 3;
        moneyOnDeath = 15;
        enemyName = "Enemy-3";
    }
}
