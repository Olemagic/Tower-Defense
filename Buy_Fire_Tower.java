import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kauficon für den Fire-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Fire_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Fire_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Buy_Fire_Tower() {
        cost = 200;
    }
    
    /**
     * Platziert einen Pseudo_Fire_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Fire_Tower tower = new Pseudo_Fire_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
