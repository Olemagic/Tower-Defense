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
    public Buy_Ninja_Tower() {
        cost = 200;
    }
    
    /**
     * Platziert einen Pseudo_Ninja_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Ninja_Tower tower = new Pseudo_Ninja_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
