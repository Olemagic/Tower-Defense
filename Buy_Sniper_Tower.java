import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buy_Sniper_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buy_Sniper_Tower extends Tower_Menu
{
    Pseudo_Sniper_Tower pseudosnipertower;
    int money;
    Level level;
    MouseInfo mouse;
    public void act()
    {
        money = ((Level) getWorld()).getMoney();
        if(Greenfoot.mouseClicked(this) && money>=400) {
            mouse = Greenfoot.getMouseInfo();
            pseudosnipertower = new Pseudo_Sniper_Tower();
            getWorld().addObject(pseudosnipertower, mouse.getX(), mouse.getY());
        }
    }
}
