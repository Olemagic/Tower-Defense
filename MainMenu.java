import greenfoot.Greenfoot;
import greenfoot.World;
/**
 * Mainmenu zur Auswahl des Levels
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class MainMenu extends World {
    Levelbutton Level1 = new Levelbutton(); //Button für Level 1
    Levelbutton Level2 = new Levelbutton(); //Button für Level 2
    
    /**
     * Constructor für Mainmenu
     */
    public MainMenu() {
        super(1600, 900, 1);
        
        addObject(Level1, 427, 600);
        addObject(Level2, 1173, 600);
    }
    
    /**
     * Act-Methode für MainMenu:<br>
     * -Beim anklicken der Levelbuttons, wird das jeweilige Level erstellt
     */
    public void act() {
        if (Greenfoot.mouseClicked(Level1)) {
            Greenfoot.setWorld(new Level_1());
        }
        else if (Greenfoot.mouseClicked(Level2)) {
            Greenfoot.setWorld(new Level_2());
        }
    }
}
