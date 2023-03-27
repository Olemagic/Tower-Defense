import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pseudo_Ninja_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pseudo_Ninja_Tower extends Pseudo_Towers
{
    /**
     * Constructor von Pseudo_Ninja_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    
    public Pseudo_Ninja_Tower(Level level) {
        world = level;
    }
    
    /**
     * Act-methode von Pseudo_Ninja_Tower:<br>
     * -Setzt die Position auf die Stelle, an der die Maus ist<br>
     * -Platziert einen Fire-Tower, wenn geklickt wird(links)<br>
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
            if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                world.addObject(new Ninja_Tower(), mouse.getX(), mouse.getY());
                world.removeMoney(200);
                world.removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                world.removeObject(this);
            }
        }
    }
}
