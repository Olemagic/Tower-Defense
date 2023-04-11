import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Kauficon für den Sprayer-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Sprayer_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Sprayer_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Buy_Sprayer_Tower() {
        cost = 500;
    }
    
    /**
     * Platziert einen Pseudo_Sprayer_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Sprayer_Tower tower = new Pseudo_Sprayer_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
