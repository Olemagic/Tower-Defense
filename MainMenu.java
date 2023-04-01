import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mainmenu zur Auswahl des Levels
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class MainMenu extends World {
    Levelbutton Level1 = new Levelbutton(1); //Button für Level 1
    Levelbutton Level2 = new Levelbutton(2); //Button für Level 2
    
    /**
     * Constructor für Mainmenu
     */
    public MainMenu() {
        super(1600, 900, 1);
        
        addObject(Level1, 427, 600);
        addObject(Level2, 1173, 600);
    }
}
