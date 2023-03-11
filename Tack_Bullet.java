import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tack_Bullet extends Bullets {
    private int lifespan = 300;
    private int timeAlive;
    
    public Tack_Bullet(int rotation) {
        setRotation(rotation);
    }
    
    public void act() {
        timeAlive+=5;
        move(5);
        if(isTouching(Monster.class)) {
          removeTouching(Monster.class);
          getWorld().removeObject(this);
          return;
        }
        
        if(this.isTouching(Tank.class)) {
            Tank Intersector = (Tank) getOneIntersectingObject(Tank.class);
            if(Intersector.getHealth() <= 1) {
              removeTouching(Tank.class);
              getWorld().removeObject(this);
            }
            else {
              Intersector.removeHealth(1);
              getWorld().removeObject(this);
            }
        }
        else if(isAtEdge()) {
          getWorld().removeObject(this);
        }
        else if(timeAlive >= lifespan) {
            getWorld().removeObject(this);
        }
    }
}
