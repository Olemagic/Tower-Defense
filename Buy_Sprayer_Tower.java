import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Buy_Sprayer_Tower extends Tower_Menu {
    public Buy_Sprayer_Tower(Level level) {
        world = level;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=500) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Sprayer_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
