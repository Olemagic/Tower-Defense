import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

/**
 * Tower, der vom Shop gespawnt wird und der Maus folgt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Pseudo_Tower extends GUI {
    protected String type; //Typ des Turms
    protected int cost; //Kosten des Turms
    protected int range; //Reichweite des Turms
    protected int thickness; //Dicke des Turms
    protected Tower_Hitbox towerhitbox; //Die Hitbox des Turms (für die Platzierung)
    protected Circle circle; //Der Kreis

    /**
     * Constructor von Pseudo_Tower:<br>
     * -Setzt je nach Typ die Kosten, Reichweite, Dicke und das Bild
     * @param pType Typ des Turms
     */
    public Pseudo_Tower(String pType) {
        type = pType;
        switch (type) {
            case "Fire":
                cost = 200;
                range = 300;
                thickness = 35;
                setImage("Fire_Tower.png");
                break;
            case "Tripleshot":
                cost = 600;
                range = 300;
                thickness = 20;
                setImage("Tripleshot_Tower.png");
                break;
            case "Sprayer":
                cost = 500;
                range = 200;
                thickness = 45;
                setImage("Sprayer_Tower.png");
                break;
            case "Sniper":
                cost = 400;
                range = 1;
                thickness = 30;
                setImage("Sniper_Tower.png");
                break;
            case "Ninja":
                cost = 200;
                range = 400;
                thickness = 15;
                setImage("Ninja_Tower.png");
                break;
            case "Ice":
                cost = 400;
                range = 200;
                thickness = 30;
                setImage("Ice_Tower.png");
                break;
        }
    }
    /**
     * Act-methode von Pseudo_Tower:<br>
     * -Setzt die Position auf die Stelle, an der die Maus ist<br>
     * -Platziert einen Tower, wenn geklickt wird(links)<br>
     * -Bricht ab, wenn geklickt wird(rechts)
     */
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            setLocation(mouseX, mouseY);
            circle.setLocation(mouseX, mouseY);
            towerhitbox.setLocation(mouseX, mouseY);
            if(mouse.getButton()==1 && towerhitbox.isNotColliding()) {
                placeTower(mouseX, mouseY);
                ((Level) getWorld()).removeMoney(cost);
                getWorld().removeObject(circle);
                getWorld().removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                getWorld().removeObject(circle);
                getWorld().removeObject(this);
            }
        }
    }
    
    /**
     * Erstellt einen Kreis, der die Reichweite des Turms anzeigt
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void addCircle(int x, int y) {
        circle = new Circle(range*2);
        getWorld().addObject(circle, x, y);
        towerhitbox = new Tower_Hitbox(thickness*2);
        getWorld().addObject(towerhitbox, x, y);
    }
    
    /**
     * Platziert je nach Typ einen Tower
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void placeTower(int x, int y) {
        switch (type) {
            case "Fire":
                getWorld().addObject(new Fire_Tower(), x, y);
                break;
            case "Tripleshot":
                getWorld().addObject(new Tripleshot_Tower(), x, y);
                break;
            case "Sprayer":
                getWorld().addObject(new Sprayer_Tower(), x, y);
                break;
            case "Sniper":
                getWorld().addObject(new Sniper_Tower(), x, y);
                break;
            case "Ninja":
                getWorld().addObject(new Ninja_Tower(), x, y);
                break;
            case "Ice":
                getWorld().addObject(new Ice_Tower(), x, y);
                break;
        }
    }
}