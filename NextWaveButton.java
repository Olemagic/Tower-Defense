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
    
    private GreenfootImage playbutton = new GreenfootImage("playbutton.png");
    private GreenfootImage speedbutton = new GreenfootImage("speedbutton.png");
    private GreenfootImage speedbuttonspeeded = new GreenfootImage("speedbutton-speeded.png");
    
    public NextWaveButton() {
        setImage(playbutton);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            if(getImage() == playbutton) {
                setImage(speedbutton);
                getWorld().getObjects(Monster_Spawner.class).get(0).disableTimeOut();
            }
            else if(getImage() == speedbutton) {
                setImage(speedbuttonspeeded);
                Greenfoot.setSpeed(60);
            }
            else if(getImage() == speedbuttonspeeded) {
                setImage(speedbutton);
                Greenfoot.setSpeed(50);
            }
        }
    }
    
    public void resetImage() {
        setImage(playbutton);
        Greenfoot.setSpeed(50);
    }
}
