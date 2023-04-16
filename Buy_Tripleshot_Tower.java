/**
 * Kauficon für den Tripleshot-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Tripleshot_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Tripleshot_Tower:<br>
     * -Setzt den Preis
     */
    public Buy_Tripleshot_Tower() {
        cost = 600;
    }
    
    /**
     * Platziert einen Pseudo_Tripleshot_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Tripleshot_Tower tower = new Pseudo_Tripleshot_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
