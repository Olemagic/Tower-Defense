import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kauficon für den Sniper-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Sniper_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Sniper_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Buy_Sniper_Tower(Level level) {
        world = level;
    }
    
    /**
     * Act-Methode von Buy_Sniper_Tower:<br>
     * -Erstellt einen Pseudo-Turm, wenn angeklickt und genug Geld verfügbar ist
     */
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=400) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Sniper_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
