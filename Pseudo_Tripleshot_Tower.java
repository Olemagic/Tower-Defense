/**
 * Tripleshot-Tower, der beim Platzieren der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Tripleshot_Tower extends Pseudo_Towers {
    /**
     * Constructor von Pseudo_Tripleshot_Tower:<br>
     * -Setzt den Preis and die Reichweite
     */
    public Pseudo_Tripleshot_Tower() {
        cost = 600;
        range = 300;
    }
    
    /**
     * Platziert einen Tripleshot_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        getWorld().addObject(new Tripleshot_Tower(), x, y);
    }
}
