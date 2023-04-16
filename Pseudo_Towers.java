import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class aller Pseudo-Towers
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Towers extends GUI {
    protected int cost; //Kosten des Turms
    protected int range; //Reichweite des Turms
    protected int thickness;
    protected Tower_Footprint towerfootprint;
    protected Circle circle; //Der Kreis
    
    /**
     * Act-methode von Pseudo_Towers:<br>
     * -Setzt die Position auf die Stelle, an der die Maus ist<br>
     * -Platziert einen Tower, wenn geklickt wird(links)<br>
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            setLocation(mouseX, mouseY);
            circle.setLocation(mouseX, mouseY);
            towerfootprint.setLocation(mouseX, mouseY);
            if(mouse.getButton()==1 && towerfootprint.isNotColliding()) {
                placeTower(mouseX, mouseY);
                ((Level) getWorld()).removeMoney(cost);
                getWorld().removeObject(circle);
                getWorld().removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                getWorld().removeObject(circle);
                getWorld().removeObject(this);
            }
        }
    }
    
    public void addCircle(int x, int y) {
        circle = new Circle(range*2);
        getWorld().addObject(circle, x, y);
        towerfootprint = new Tower_Footprint(thickness*2);
        getWorld().addObject(towerfootprint, x, y);
    }
    
    /**
     * Platziert einen Tower(Wird erst in Subclasses definiert)
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y){}
}