import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zweiter Gegner
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Tank extends Enemy {
    /**
     * Constructor für Tank
     * Legt Attribute fest
     */
    public Tank() {
        //config
        health = 5;
        damage = 2;
        enemyName = "Enemy-2";
    }
    
    /**
     * Act-Methode von Tank:
     * -Aktualisiert das Bild alle 5 acts
     * -Überprüft, ob der Gegner tot ist und entfernt ihn
     * -Sucht den nächsten Weg und bewegt sich
     */
    public void act() {
        if (numberOfActs%5 == 0) {
            updateImage();
        }
        
        if (health <= 0) {
            ((Level) getWorld()).addMoney(40);
            getWorld().removeObject(this);
            return;
        }
        
        switch(numberOfActs) {
            case 1: {findNextPath(); break;}
            case 100: {numberOfActs = 0;}
        }
        move(1);
        distanceMoved += 1;
        numberOfActs++;
    }
}
