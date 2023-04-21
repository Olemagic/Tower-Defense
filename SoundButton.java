import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

/**
 * Button zum An- und Ausschalten der Musik
 * @author Ole, Oskar, Shikri, Timo
 * @version 1.0
 */
public class SoundButton extends GUI {
    private boolean gameOver = false; //Spielzustand

    private final GreenfootImage soundOn = new GreenfootImage("soundon.png"); //Bild vom Button bei Sound an
    private final GreenfootImage soundOff = new GreenfootImage("soundoff.png"); //Bild vom Button bei Sound aus

    /**
     * Act-Methode von SoundButton:<br>
     * -Wenn angeklickt wird die Musik an- oder ausgeschaltet
     */
    public void act() {
        if (gameOver) return;

        if (Greenfoot.mouseClicked(this)) {
            GreenfootSound sound = ((Level) getWorld()).getMusic();
            if (getImage() == soundOn) {
                setImage(soundOff);
                sound.pause();
            }
            else if (getImage() == soundOff) {
                setImage(soundOn);
                sound.playLoop();
            }
        }
    }

    /**
     * Setzt das Bild zurück auf Musik aus
     */
    public void resetImage() {
        setImage(soundOn);
    }

    /**
     * Setzt den Spielzustand auf beendet
     */
    public void setGameOver() {
        gameOver = true;
    }
}
