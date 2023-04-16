/**
 * Sniper-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Sniper_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Sniper_Tower:<br>
     * -Setzt den Preis and die Reichweite
     */
    public Pseudo_Sniper_Tower() {
        cost = 400;
        range = 1;
        thickness = 30;
    }

    /**
     * Platziert einen Sniper_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        getWorld().addObject(new Sniper_Tower(), x, y);
    }
}
