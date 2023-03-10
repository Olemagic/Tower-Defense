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
    private int ammountOfMonstersSpawned = 0;
    private int numberOfActs = 0;
    private int currentWave = 1;
    private boolean waveTimeOut = true;
    
    public void act() {
        if(!waveTimeOut) {
            waveGeneration(currentWave);
            numberOfActs++;
        }
        else {
            if(getWorld().getObjects(Enemy.class).size() == 0) {
            getWorld().getObjects(NextWaveButton.class).get(0).resetImage();
            }
        }
    }
    
    public void disableTimeOut() {
        waveTimeOut = false;
    }
    
    public void waveGeneration(int waveNumber) {
        switch(waveNumber){
            case 1: spawnMonster(10, 100); break;
            case 2: spawnMonster(8, 500); break;
            case 3: spawnMonster(5, 100); break;
        }
    }
    
    public void spawnMonster(int ammountOfMonsters, int waitTime) {
        if(numberOfActs%waitTime == 1 && ammountOfMonsters>ammountOfMonstersSpawned) {
            Enemy newMonster = new Tank();
            ((Level_1)getWorld()).addObject(newMonster, 50, 450);
            ammountOfMonstersSpawned++;
        }
        if(ammountOfMonsters==ammountOfMonstersSpawned) {
            ammountOfMonstersSpawned = 0;
            currentWave++;
            waveTimeOut = true;
        }
    }
}
