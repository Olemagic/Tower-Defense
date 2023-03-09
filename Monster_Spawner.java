import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster_Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster_Spawner extends Actor
{
    /**
     * Act - do whatever the Monster_Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int numberOfActs = 0;
    
    public void act() {
        numberOfActs++;
        switch(numberOfActs) {
            case 1: spawnMonster(); break;
            case 20: spawnMonster(); break;
            case 40: spawnMonster(); break;
            case 100: spawnMonster(); break;
            case 200: spawnMonster(); break;
        }
    }
    
    public void spawnMonster() {
        Monster newMonster = new Monster();
        ((Level_1)getWorld()).addObject(newMonster, 50, 450);
    }
}
