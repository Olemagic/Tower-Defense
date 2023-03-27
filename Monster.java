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
        enemyName = "Enemy-1";
    }
    
    /**
     * Act-Methode von Monster:<br>
     * -Aktualisiert das Bild alle 5 acts<br>
     * -Überprüft, ob der Gegner tot ist und entfernt ihn<br>
     * -Sucht den nächsten Weg und bewegt sich
     */
    public void act() {
        if (numberOfActs%5 == 0) {
            updateImage();
        }
        
        if (health <= 0) {
            ((Level) getWorld()).addMoney(20);
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
