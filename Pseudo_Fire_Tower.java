import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fire-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Fire_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Fire_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Pseudo_Fire_Tower(Level level) {
        world = level;
    }

    /**
     * Act-methode von Pseudo_Fire_Tower:<br>
     * -Setzt die Position auf die Stelle, an der die Maus ist<br>
     * -Platziert einen Fire-Tower, wenn geklickt wird(links)<br>
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
            if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                world.addObject(new Fire_Tower(), mouse.getX(), mouse.getY());
                world.removeMoney(200);
                world.removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                world.removeObject(this);
            }
        }
    }
}
