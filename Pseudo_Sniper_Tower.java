import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pseudo_Sniper_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pseudo_Sniper_Tower extends Pseudo_Towers
{
    MouseInfo mouse;
    public void act()
    {
        mouse = Greenfoot.getMouseInfo();
        if(mouse!=null) {
            setLocation(mouse.getX(), mouse.getY());
                if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                getWorld().addObject(new Sniper_Tower(), mouse.getX(), mouse.getY());
                ((Level) getWorld()).removeMoney(400);
                getWorld().removeObject(this);
            }
            if(mouse.getButton()==3) {
                getWorld().removeObject(this);
            }
        }
    }
}
