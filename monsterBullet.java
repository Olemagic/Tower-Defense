import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class monsterBullet extends Bullets {
    public monsterBullet(int rotation) {
        setRotation(rotation);
    }
    
    public void act() {
        move(5);
        if(isTouching(Monster.class)) {
          removeTouching(Monster.class);
          getWorld().removeObject(this);
          return;
        }
        
        if(isTouching(Tank.class)) {
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
    }
}
