import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Parent-class für alle Gegner, gemeinsame Methoden und Attribute
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0 
 */
public class Enemy extends Actor {
    protected int health; //Leben
    protected int damage; //Schaden beim Erreichen vom Ziel
    protected int moneyOnDeath; //Geld, welches der Gegner beim Tod fallen lässt
    protected int speed; //Geschwindigkeit (
    protected int freezeTime = 0; //übrige Frierzeit
    
    protected String enemyName; //Name(für Animation)
    
    protected int distanceMoved = 50; //Bereits zurückgelegte Strecke
    protected int currentImage; //Zähler für Animation
    
    /**
     * Act-Methode von Enemy:<br>
     * -Überprüft, ob der Gegner keine Leben mehr hat und entfernt ihn<br>
     * -Animation<br>
     * -Timing fürs Weg-finden<br>
     * -Bewegung der Gegner
     */
    public void act() {
        if (health <= 0) {
            ((Level) getWorld()).addMoney(moneyOnDeath);
            getWorld().removeObject(this);
            return;
        }
        
        if(freezeTime==0) {
            if (distanceMoved%5 == 0) {
                updateImage();
            }
            if(distanceMoved%100 < speed){
                findNextPath();
            }
            move(speed);
            distanceMoved += speed;
        }
        else {
            freezeTime--;
        }
    }
    
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
     * Setzt die zurückgelegte Strecke
     * @param distance  Strecke, die gesetzt werden soll
     */
    public void setDistanceMoved(int distance) {distanceMoved = distance;}
    
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
    
    /**
     * Friert den Gegner für 250 Acts
     */
    public void freeze() {
        freezeTime = 250;
    }
}