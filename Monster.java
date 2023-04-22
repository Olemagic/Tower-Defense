/**
 * Erster Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Monster extends Enemy {
    /**
     * Constructor für Monster:<br>
     * -Setzt Leben, Schaden, Geschwindigkeit, Todesgeld und Namen
     */
    public Monster() {
        //config
        health = 2;
        damage = 2;
        speed = 1;
        moneyOnDeath = 10;
        enemyName = "Enemy-1";
    }
}
