import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pseudo_Tripleshot_Tower extends Pseudo_Towers {
    public Pseudo_Tripleshot_Tower(Level level) {
        world = level;
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
            if(mouse.getButton()==1 && getOneIntersectingObject(Actor.class) == null) {
                world.addObject(new Tripleshot_Tower(), mouse.getX(), mouse.getY());
                world.removeMoney(600);
                world.removeObject(this);
            }
            
            if(mouse.getButton()==3) {
                world.removeObject(this);
            }
        }
    }
}
