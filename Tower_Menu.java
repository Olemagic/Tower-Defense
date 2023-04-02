import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class aller Buy-Towers
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Tower_Menu extends GUI {
    protected int cost; //Kosten des Turms
    protected boolean gameOver = false; //Spielzustand
    
    /**
     * Act-Methode von Tower_Menu:<br>
     * -Erstellt einen Pseudo-Turm, wenn angeklickt und genug Geld verfügbar ist
     */
    public void act() {
        if (gameOver) return;
        
        if(Greenfoot.mouseClicked(this) && ((Level) getWorld()).getMoney()>=cost) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            placePseudo_Tower(mouse.getX(), mouse.getY());
        }
    }
    
    /**
     * Platziert einen Pseudo_Tower(Wird erst in Subclasses definiert)
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {}

    /**
     * Setzt den Spielzustand auf beendet
     */
    public void setGameOver() {
        gameOver = true;
    }
}
