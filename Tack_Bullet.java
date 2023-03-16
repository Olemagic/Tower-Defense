import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tack_Bullet extends Bullets {
    //config
    private int lifespan = 300;
    private int timeAlive = 0;
    
    public Tack_Bullet(int rotation, int pDamage) {
        setRotation(rotation);
        damage = pDamage;
        pierce = 3;
        hitEnemies = new Enemy[pierce];
    }
    
    public void act() {
        super.act();
        timeAlive +=5;
        if(timeAlive >= lifespan) {
            getWorld().removeObject(this);
        }
    }
}
