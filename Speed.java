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
        enemyName = "Enemy-3";
        numberOfActs = 26;
    }
    
    /**
     * Act-Methode von Speed:<br>
     * -Aktualisiert das Bild alle 5 acts<br>
     * -Überprüft, ob der Gegner tot ist und entfernt ihn<br>
     * -Sucht den nächsten Weg und bewegt sich
     */
    public void act() {
        if (numberOfActs%5 == 0) {
            updateImage();
        }
        
        if (health <= 0) {
            ((Level) getWorld()).addMoney(30);
            getWorld().removeObject(this);
            return;
        }
        
        switch(numberOfActs) {
            case 1: {findNextPath(); break;}
            case 50: {numberOfActs = 0;}
        }
        move(2);
        distanceMoved += 2;
        numberOfActs++;
    }
}
