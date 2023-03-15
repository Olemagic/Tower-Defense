import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Buy_Sniper_Tower extends Tower_Menu {
    public Buy_Sniper_Tower(Level level) {
        world = level;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=400) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Sniper_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
