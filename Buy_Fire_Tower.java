import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Buy_Fire_Tower extends Tower_Menu {
    public Buy_Fire_Tower(Level level) {
        world = level;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=200) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Fire_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
