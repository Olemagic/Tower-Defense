import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  // (List)

/**
 * Button zum Starten der nächsten Welle und zum Schneller-machen
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class NextWaveButton extends GUI {
    private boolean isSpeeded = false; //Geschwindigkeitszustand
    
    private GreenfootImage playbutton = new GreenfootImage("playbutton.png"); //Bild vom Button bei keiner aktuellen Welle
    private GreenfootImage speedbutton = new GreenfootImage("speedbutton.png"); //Bild vom Button bei Welle und nicht beschleunigt
    private GreenfootImage speedbuttonspeeded = new GreenfootImage("speedbutton-speeded.png"); //Bild vom Button bei Welle und beschleunigt
    
    /**
     * Act-Methode von NextWaveButton:<br>
     * -Bei Klick: Startet die nächste Welle oder ändert die Geschwindigkeit
     */
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            if(getImage() == playbutton) {
                if (isSpeeded) {
                    setImage(speedbuttonspeeded);
                    Greenfoot.setSpeed(60);
                }
                else {
                    setImage(speedbutton);
                    Greenfoot.setSpeed(50);
                }
                getWorld().getObjects(Monster_Spawner.class).get(0).disableTimeOut();
            }
            else if(getImage() == speedbutton) {
                setImage(speedbuttonspeeded);
                isSpeeded = true;
                Greenfoot.setSpeed(60);
            }
            else if(getImage() == speedbuttonspeeded) {
                setImage(speedbutton);
                isSpeeded = false;
                Greenfoot.setSpeed(50);
            }
        }
    }
    
    /**
     * Setzt das Bild zurück auf keine Welle aktiv
     */
    public void resetImage() {
        setImage(playbutton);
    }
}
