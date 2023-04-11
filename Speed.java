import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dritter Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
    public class Speed extends Enemy {
    /**
     * Constructor für Speed:<br>
     * -Setzt Leben, Schaden und Namen
     */
    public Speed() {
        //config
        health = 1;
        damage = 1;
        speed = 3;
        moneyOnDeath = 15;
        enemyName = "Enemy-3";
    }
}
