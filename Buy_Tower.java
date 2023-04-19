import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent-class aller Buy-Towers
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Buy_Tower extends GUI {
    protected String type; //Typ des Turms
    protected int cost; //Kosten des Turms
    protected boolean gameOver = false; //Spielzustand

    /**
     * Constructor von Buy_Tower:<br>
     * -Setzt je nach Typ die Kosten und das Bild
     * @param pType Typ des Turms
     */
    public Buy_Tower(String pType) {
        type = pType;
        switch (type) {
            case "Fire":
                cost = 200;
                setImage("Fire_Tower.png");
                break;
            case "Tripleshot":
                cost = 600;
                setImage("Tripleshot_Tower.png");
                break;
            case "Sprayer":
                cost = 500;
                setImage("Sprayer_Tower.png");
                break;
            case "Sniper":
                cost = 400;
                setImage("Sniper_Tower.png");
                break;
            case "Ninja":
                cost = 200;
                setImage("Ninja_Tower.png");
                break;
            case "Ice":
                cost = 400;
                setImage("Ice_Tower.png");
                break;
        }
    }

    /**
     * Act-Methode von Buy_Tower:<br>
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
     * Platziert je nach Typ einen Pseudo-Turm und fügt ihm einen Range-Kreis hinzu
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placePseudo_Tower(int x, int y) {
        Pseudo_Tower tower = null;
        switch (type) {
            case "Fire":
                tower = new Pseudo_Tower("Fire");
                break;
            case "Tripleshot":
                tower = new Pseudo_Tower("Tripleshot");
                break;
            case "Sprayer":
                tower = new Pseudo_Tower("Sprayer");
                break;
            case "Sniper":
                tower = new Pseudo_Tower("Sniper");
                break;
            case "Ninja":
                tower = new Pseudo_Tower("Ninja");
                break;
            case "Ice":
                tower = new Pseudo_Tower("Ice");
                break;
        }
        assert tower != null;
        getWorld().addObject(tower, x, y);
        tower.addCircle(x, y);
    }

    /**
     * Setzt den Spielzustand auf beendet
     */
    public void setGameOver() {
        gameOver = true;
    }
}
