import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Buy_Fire_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buy_Fire_Tower extends Tower_Menu
{
    Pseudo_Fire_Tower pseudofiretower;
    int money;
    Level level;
    MouseInfo mouse;
    public void act()
    {
        money = ((Level) getWorld()).getMoney();
        if(Greenfoot.mouseClicked(this) && money>=200) {
            mouse = Greenfoot.getMouseInfo();
            pseudofiretower = new Pseudo_Fire_Tower();
            getWorld().addObject(pseudofiretower, mouse.getX(), mouse.getY());
        }
    }
}
