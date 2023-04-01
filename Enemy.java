import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Parent-class für alle Gegner, gemeinsame Methoden und Attribute
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Enemy extends Actor {
    protected int health; //Leben
    protected int damage; //Schaden beim Erreichen vom Ziel
    protected String enemyName; //Name(für Animation)
    
    protected int distanceMoved; //Bereits zurückgelegte Strecke
    protected int numberOfActs = 51; //Wichtig fürs Wegfinden und Animation
    protected int currentImage; //Zähler für Animation
    /**
     * Entfernt Leben
     * @param damage    Entfernt den Wert vom Leben
     */
    public void removeHealth(int damage) {health -= damage;}
    
    /**
     * Überprüft, ob der Gegner kein Leben mehr hat und entfernt ihn
     */
    public void isDead() {
        if (health <= 0) {
            ((Level) getWorld()).addMoney(20);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Gibt Schaden zurück
     * @return Schaden vom Gegner
     */
    public int getDamage() {return damage;}
    
    /**
     * Gibt die zurückgelegte Strecke zurück
     * @return Zurückgelegte Strecke
     */
    public int getDistanceMoved() {return distanceMoved;}
    
    /**
     * Sucht den nächsten Weg und dreht sich in die Richtung
     */
    public void findNextPath() {
        int rotation = getRotation();
        
        if (rotation == 0) {
            if (getOneObjectAtOffset(100, 0, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
            }
            return;
        }
        
        if (rotation == 90) {
            if (getOneObjectAtOffset(0, 100, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
            }
            return;
        }
        
        if (rotation == 180) {
            if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(0, 100, Path.class) != null) {
                setRotation(90);
            }
            else if (getOneObjectAtOffset(0, -100, Path.class) != null) {
                setRotation(270);
            }
            return;
        }
        
        if (rotation == 270) {
            if (getOneObjectAtOffset(0, -100, Path.class) != null) {
            }
            else if (getOneObjectAtOffset(-100, 0, Path.class) != null) {
                setRotation(180);
            }
            else if (getOneObjectAtOffset(100, 0, Path.class) != null) {
                setRotation(0);
            }
            return;
        }
    }
    
    /**
     * Ändert das Bild auf das nächste in der Animation
     */
    public void updateImage() {
        setImage(enemyName + "/" + currentImage + ".png");
        currentImage++;
        if (currentImage == 19) currentImage = 0;
    }
}