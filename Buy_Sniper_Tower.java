/**
 * Kauficon für den Sniper-Tower
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Sniper_Tower extends Tower_Menu {
    /**
     * Constructor für Buy_Sniper_Tower:<br>
     * -Setzt den Preis
     */
    public Buy_Sniper_Tower() {
        cost = 400;
    }
    
    /**
     * Platziert einen Pseudo_Sniper_Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Sniper_Tower tower = new Pseudo_Sniper_Tower();
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }
}
