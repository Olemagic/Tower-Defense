import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kauficon für den Ice-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Ice_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Fire_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Buy_Ice_Tower() {
        cost = 400;
    }
    
    /**
     * Platziert einen Pseudo_Fire_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Ice_Tower tower = new Pseudo_Ice_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
