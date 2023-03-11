import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monster extends Enemy {
    private int numberOfActs = 51;
    private int distanceMoved = 0;
    
    public void act() {
        switch(numberOfActs) {
            case 1: {findNextPath(); break;}
            case 100: {numberOfActs = 0;}
        }
        move(1);
        distanceMoved += 1;
        numberOfActs++;
    }
}
