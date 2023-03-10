import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class NextWaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextWaveButton extends GUI
{
    /**
     * Act - do whatever the NextWaveButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean isSpeeded = false;
    private GreenfootImage playbutton = new GreenfootImage("playbutton.png"); //state 0
    private GreenfootImage speedbutton = new GreenfootImage("speedbutton.png"); //state 1
    private GreenfootImage speedbuttonspeeded = new GreenfootImage("speedbutton-speeded.png"); //state 2
    
    public NextWaveButton() {
        setImage(playbutton);
    }
    
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
    
    public void resetImage() {
        setImage(playbutton);
        Greenfoot.setSpeed(50);
    }
}
