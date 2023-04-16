/**
 * Eis-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Ice_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Ninja_Tower:<br>
     * -Setzt den Preis and die Reichweite
     */
    public Pseudo_Ice_Tower() {
        cost = 400;
        range = 200;
    }
    
    /**
     * Platziert einen Ninja_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        getWorld().addObject(new Ice_Tower(), x, y);
    }
}
