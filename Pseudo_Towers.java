import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class aller Pseudo-Towers
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Towers extends GUI {
    protected int cost; //Kosten des Turms
    
    /**
     * Act-methode von Pseudo_Towers:<br>
     * -Setzt die Position auf die Stelle, an der die Maus ist<br>
     * -Platziert einen Tower, wenn geklickt wird(links)<br>
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
            if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                placeTower(mouse.getX(), mouse.getY());
                ((Level) getWorld()).removeMoney(cost);
                getWorld().removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                getWorld().removeObject(this);
            }
        }
    }
    
    /**
     * Platziert einen Tower(Wird erst in Subclasses definiert)
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y){}
}