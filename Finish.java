import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Finish extends Actor {
    public void act() {
        List<Enemy> enemies = getIntersectingObjects(Enemy.class);
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getY() != 0) {return;}
            
            Level world = (Level) getWorld();
            world.removeHealth(1);
            world.removeObject(enemies.get(i));
        }
    }
}
