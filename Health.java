import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Lebensanzeige in der Welt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Health extends GUI {
    private final Level world; //Die Welt
    private final GreenfootImage image = new GreenfootImage(150, 50); //Das Bild
    
    /**
     * Constructor für Health:<br>
     * -Speichert die Welt und erstellt das Bild
     * @param level Die Welt
     */
    public Health(Level level) {
        world = level;
        update();
    }
    
    /**
     * Act-Methode von Health:<br>
     * -Aktualisiert die Anzeige
     */
    public void act() {
        update();
    }
    
    /**
     * Aktualisiert das Bild:<br>
     * -Löscht aktuelles Bild<br>
     * -Erstellt das neue Bild mit Icon und Text
     */
    public void update() {
        //Das Leben
        int health = world.getHealth();
        
        image.clear();
        
        GreenfootImage heart = new GreenfootImage("heart.png");
        image.drawImage(heart, 0, 0);
        
        GreenfootImage healthtext = new GreenfootImage(String.valueOf(health), 50, Color.WHITE, null, Color.BLACK);
        image.drawImage(healthtext, 50, 0);
        
        setImage(image);
    }
}
