import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster extends Enemy {
    public Monster() {
        //config
        health = 1;
        damage = 1;
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
