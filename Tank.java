import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tank extends Enemy {
    public Tank() {
        //config
        health = 5;
        damage = 2;
    }
    
    public void act() {
        if (health <= 0) {
            getWorld().removeObject(this);
            return;
        }
        
        switch(numberOfActs) {
            case 1: {findNextPath(); break;}
            case 100: {numberOfActs = 0;}
        }
        move(1);
        distanceMoved += 1;
        numberOfActs++;
    }
}
