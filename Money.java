import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Money extends GUI{
    private Level world;
    private int money;
    private GreenfootImage image = new GreenfootImage(150, 50);
    
    public Money(Level level) {
        world = level;
        update();
    }
    
    public void act() {
        update();
    }
    
    public void update() {
        money = world.getMoney();
        
        
        image.clear();
        
        GreenfootImage heart = new GreenfootImage("money.png");
        image.drawImage(heart, 0, 0);
        
        GreenfootImage healthtext = new GreenfootImage("" + money, 50, Color.WHITE, null, Color.BLACK);
        image.drawImage(healthtext, 50, 0);
        
        setImage(image);
    }
}
