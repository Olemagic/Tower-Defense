import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Health extends GUI{
    private Level world;
    private int health;
    private GreenfootImage image = new GreenfootImage(150, 50);
    
    public Health(Level level) {
        world = level;
        update();
    }
    
    public void act() {
        update();
    }
    
    public void update() {
        health = world.getHealth();
        
        
        image.clear();
        
        GreenfootImage heart = new GreenfootImage("heart.png");
        image.drawImage(heart, 0, 0);
        
        GreenfootImage healthtext = new GreenfootImage("" + health, 50, Color.WHITE, null, Color.BLACK);
        image.drawImage(healthtext, 50, 0);
        
        setImage(image);
    }
}
