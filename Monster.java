import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster extends Enemy {
    public Monster() {
        //config
        health = 1;
        damage = 1;
        enemyName = "Enemy-1";
    }
    
    public void act() {
        if (numberOfActs%5 == 0) {
            updateImage();
        }
        
        if (health <= 0) {
            ((Level) getWorld()).addMoney(20);
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
