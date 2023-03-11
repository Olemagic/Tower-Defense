import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class NextWaveButton extends GUI {
    private boolean isSpeeded = false;
    
    private GreenfootImage playbutton = new GreenfootImage("playbutton.png");
    private GreenfootImage speedbutton = new GreenfootImage("speedbutton.png");
    private GreenfootImage speedbuttonspeeded = new GreenfootImage("speedbutton-speeded.png");
    
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
    }
}
