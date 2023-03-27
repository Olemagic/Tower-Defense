import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Geldanzeige in der Welt
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class Money extends GUI{
    private Level world; //Die Welt
    private int money; //Das Geld
    private GreenfootImage image = new GreenfootImage(150, 50); //Das Bild
    
    /**
     * Constructor für Money:
     * -Speichert die Welt und erstellt das Bild
     */
    public Money(Level level) {
        world = level;
        update();
    }
    
    /**
     * Act-Methode von Money
     */
    public void act() {
        update();
    }
    /**
     * Aktualisiert das Bild:
     * -Entfernt das Bild
     */
    public void update() {
        money = world.getMoney();
        
        
        image.clear();
        
        GreenfootImage heart = new GreenfootImage("money.png");
        image.drawImage(heart, 0, 0);
        
        GreenfootImage healthtext = new GreenfootImage("" + money, 50, Color.WHITE, null, Color.BLACK);
        image.drawImage(healthtext, 50, 0);
        
        setImage(image);
    }
}
