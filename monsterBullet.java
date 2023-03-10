import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class monsterBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class monsterBullet extends Bullets
{
    /**
     * Act - do whatever the monsterBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private double rotation;
    private boolean isInWorld;
    
    public monsterBullet(double pRotation) {
        this.rotation = pRotation;
        setRotation((int) rotation);
    }
    
    public void act() {
        move(5);
        if(this.isTouching(Monster.class)) {
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
              Intersector.removeHealth(2);
              getWorld().removeObject(this);
            }
        }
        else if(this.isAtEdge()) {
          getWorld().removeObject(this);
        }
    }
}
