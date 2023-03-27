import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kauficon für den Fire-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Ninja_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Fire_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Buy_Ninja_Tower(Level level) {
        world = level;
    }
    
    /**
     * Act-Methode von Buy_Ninja_Tower:<br>
     * -Erstellt einen Pseudo-Turm, wenn angeklickt und genug Geld verfügbar ist
     */
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=200) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Ninja_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
