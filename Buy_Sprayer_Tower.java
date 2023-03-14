import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buy_Sprayer_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buy_Sprayer_Tower extends Tower_Menu
{
    Pseudo_Sprayer_Tower pseudosprayertower;
    int money;
    Level level;
    MouseInfo mouse;
    public void act()
    {
        money = ((Level) getWorld()).getMoney();
        if(Greenfoot.mouseClicked(this) && money>=500) {
            mouse = Greenfoot.getMouseInfo();
            pseudosprayertower = new Pseudo_Sprayer_Tower();
            getWorld().addObject(pseudosprayertower, mouse.getX(), mouse.getY());
        }
    }
}
