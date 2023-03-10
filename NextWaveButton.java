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
    
    private int resetColorDelay = 0;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            setImage("button-blue.png");
            getWorld().getObjects(Monster_Spawner.class).get(0).disableTimeOut();
            resetColorDelay = 20;
        }
        if(resetColorDelay == 1) {
            setImage("button-green.png");
        }
        if(resetColorDelay > 0) {
            resetColorDelay--;
        }
    }
}
