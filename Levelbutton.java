import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button im Mainmemnu zum Level-wählen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Levelbutton extends GUI {
    private int levelNumber; //Levelnummer
    
    /**
     * Constructor für Levelbutton:
     * -speichert das Level, für welches der Button funktioniert
     */
    public Levelbutton(int pLevelNumber) {
        levelNumber = pLevelNumber;
    }
    
    /**
     * Act-Methode für Levelbutton:
     * -Beim anklicken, wird je nach dem gespeicherten Level die Welt gesetzt
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            switch (levelNumber) {
                case 1: Greenfoot.setWorld(new Level_1()); break;
                case 2: Greenfoot.setWorld(new Level_2()); break;
            }
        }
    }
}
