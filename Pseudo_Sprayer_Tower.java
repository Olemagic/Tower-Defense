import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sprayer-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Sprayer_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Sprayer_Tower:<br>
     * -Setzt die Welt
     * @param level Die Welt
     */
    public Pseudo_Sprayer_Tower() {
        cost = 500;
        range = 200;
    }
    
    /**
     * Platziert einen Sprayer_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        getWorld().addObject(new Sprayer_Tower(), x, y);
    }
}
