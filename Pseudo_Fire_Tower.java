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
    public Pseudo_Fire_Tower() {
        cost = 200;
        range = 300;
    }
    
    /**
     * Platziert einen Fire_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        getWorld().addObject(new Fire_Tower(), x, y);
    }
}
