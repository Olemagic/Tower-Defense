import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Erster Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Monster extends Enemy {
    /**
     * Constructor für Monster:<br>
     * -Setzt Leben, Schaden und Namen
     */
    public Monster() {
        //config
        health = 1;
        damage = 1;
        speed = 1;
        moneyOnDeath = 10;
        enemyName = "Enemy-1";
    }
}
