import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lebensanzeige in der Welt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Health extends GUI{
    private Level world; //Die Welt
    private int health; //Das Leben
    private GreenfootImage image = new GreenfootImage(150, 50); //Das Bild
    
    /**
     * Constructor für Health:
     * -Speichert die Welt und erstellt das Bild
     */
    public Health(Level level) {
        world = level;
        update();
    }
    
    /**
     * Act-Methode von Health:
     * -Aktualisiert die Anzeige
     */
    public void act() {
        update();
    }
    
    /**
     * Aktualisiert das Bild:
     * -Löscht aktuelles Bild
     * -Erstellt das neue Bild mit Icon und Text
     */
    public void update() {
        health = world.getHealth();
        
        image.clear();
        
        GreenfootImage heart = new GreenfootImage("heart.png");
        image.drawImage(heart, 0, 0);
        
        GreenfootImage healthtext = new GreenfootImage("" + health, 50, Color.WHITE, null, Color.BLACK);
        image.drawImage(healthtext, 50, 0);
        
        setImage(image);
    }
}
