import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * tripleshot-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Tripleshot_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Tripleshot_Tower:
     * -Setzt die Welt
     */
    public Pseudo_Tripleshot_Tower(Level level) {
        world = level;
    }
    
    /**
     * Act-methode von Pseudo_Tripleshot_Tower:
     * -Setzt die Position auf die Stelle, an der die Maus ist
     * -Platziert einen Tripleshot-Tower, wenn geklickt wird(links)
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
            if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                world.addObject(new Tripleshot_Tower(), mouse.getX(), mouse.getY());
                world.removeMoney(600);
                world.removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                world.removeObject(this);
            }
        }
    }
}
