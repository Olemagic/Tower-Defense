import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Buy_Tripleshot_Tower extends Tower_Menu {
    public Buy_Tripleshot_Tower(Level level) {
        world = level;
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this) && world.getMoney()>=600) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            getWorld().addObject(new Pseudo_Tripleshot_Tower(world), mouse.getX(), mouse.getY());
        }
    }
}
